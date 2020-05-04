package edu.ben.cmsc3330.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ben.cmsc3330.data.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import static edu.ben.cmsc3330.web.security.SecurityConstants.SECRET;


@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        // only run this on login requests
        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
    }

    /**
     * Authentication given email and password credentials
     * @param request HTTP Request
     * @param response HTTP Response
     * @return User Authentication
     * @throws AuthenticationException Invalid Authentication
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            // grab the credentials. this comes in as a json object, not a form request so it needs
            // to be converted
            User credentials = new ObjectMapper().readValue(request.getInputStream(), User.class);
            log.info("trying to authentication user with email [{}] and password [{}]", credentials.getEmail(), credentials.getPassword());
            // do the authentication
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            log.error("caught IOException reading credentials from request input stream", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * this is where the JWT token is added to the header after successful auth
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) {
        // get the user out of the authenticated principal
        var user = ((User) authentication.getPrincipal());
        log.info("authenticated user is [{}]", user);

        // map the roles from the authorities
        var roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        log.info("mapped roles are [{}]", roles);
        // set up the encryption key
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(secretBytes, SignatureAlgorithm.HS512.getJcaName());

        // build the token
        var token = Jwts.builder()
                .signWith(signingKey)
                .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("rol", roles)
                .compact();
        // add the bearer token to the response headers
        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
    }
}
