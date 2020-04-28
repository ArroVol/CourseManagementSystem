package edu.ben.cmsc3330.web.security;

import edu.ben.cmsc3330.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;

    // The @Enable*Security annotations create a global AuthenticationManagerBuilder
    // that can optionally be used for creating an AuthenticationManager that is shared
    // The key to using it is to use the @Autowired annotation
    // see http://stackoverflow.com/questions/19353578/security-method-annotations-with-java-configuration-and-spring-security-3-2
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // enable CORS protection
                .cors()
                .and()
                // disable csrf
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .authorizeRequests()
                // Some sample PUBLIC APIS
                .antMatchers(HttpMethod.POST, "/api/password/request").permitAll()
                .antMatchers(HttpMethod.POST, "/api/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users/*/register").permitAll()

                .antMatchers(HttpMethod.POST, "/api/users/*/password/change").permitAll()
                .antMatchers(HttpMethod.GET, "/api/address/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/address").permitAll()

                .antMatchers(HttpMethod.GET, "/api/view-courses/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/view-courses").permitAll()

                .antMatchers(HttpMethod.GET, "/api/drop-courses/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/drop-courses").permitAll()

                .antMatchers(HttpMethod.GET, "/api/enroll/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/enroll").permitAll()

                .antMatchers(HttpMethod.GET, "/api/section/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/section").permitAll()
                .antMatchers(HttpMethod.GET, "/api/section/summer").permitAll()
                .antMatchers(HttpMethod.GET, "/api/section/term/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/section/term").permitAll()
                .antMatchers(HttpMethod.GET, "/api/section/term/summer").permitAll()

                .antMatchers(HttpMethod.GET, "/api/term/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/term").permitAll()

                .antMatchers(HttpMethod.GET, "/api/course/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/course").permitAll()

                .antMatchers(HttpMethod.GET, "/api/course/subject/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/course/subject").permitAll()

                .antMatchers(HttpMethod.GET, "/api/course/name/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/course/name").permitAll()

                .antMatchers(HttpMethod.GET, "/api/user/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user").permitAll()

                .antMatchers(HttpMethod.GET, "/api/user/retrieve/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/retrieve").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/retrieve/*/*").permitAll()

                .antMatchers(HttpMethod.GET, "/api/registration/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/registration").permitAll()

                .antMatchers(HttpMethod.GET, "/api/registration/register/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/registration/register").permitAll()




                // HEALTH APIS
                .antMatchers("/actuator").permitAll()
                .antMatchers("/actuator/**").permitAll()
                // PROTECT THE REST
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.addExposedHeader("Authorization");
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedOrigin("http://localhost:4200");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
