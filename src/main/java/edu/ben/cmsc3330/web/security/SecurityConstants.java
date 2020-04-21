package edu.ben.cmsc3330.web.security;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/authenticate";
    public static final String SECRET = "8j4fpjofaj89h3ojfyTFT(#H)Ryf308hj(F7)(*JF3(*fh9382f";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "cmsc3330-api";
    public static final String TOKEN_AUDIENCE = "cmsc3330-app";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
