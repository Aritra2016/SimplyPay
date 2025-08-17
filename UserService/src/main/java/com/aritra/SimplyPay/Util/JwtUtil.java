package com.aritra.SimplyPay.Util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;


@Component // This annotation indicates that this class is a Spring component, allowing it to be automatically detected and managed by the Spring container.

public class JwtUtil {

    private static final String secret="aeitrafdd@23$$"; // This is a static final variable that holds the secret key used for signing and verifying JWT tokens. It should be kept secure and not hard-coded in production applications.

    private Key getSigInKey(){

        return Keys.hmacShaKeyFor(secret.getBytes()); // This method generates a signing key from the secret string. The secret is converted to bytes and used to create a signing key using HMAC SHA algorithm.
    }

   //function to fetch mail from token
    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigInKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // This method extracts the email from the JWT token by parsing it and retrieving the subject claim, which is expected to be the email address.
    }

    public boolean validatetoken(String token,String name){
        try {
            extractEmail(token); // This line attempts to extract the email from the token. If successful, it means the token is valid.
            return true; // If the extraction is successful, the method returns true, indicating that the token is valid.
        } catch (Exception e) {
            return false; // If an exception occurs during the extraction (e.g., if the token is invalid or expired), the method catches the exception and returns false, indicating that the token is not valid.
        }
        }

        public String extractUserName(String token){
            return Jwts.parserBuilder()
                    .setSigningKey(getSigInKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }

        public String generateToken(Map<String, Object> claims,String mail){
         return Jwts.builder()
                 .setClaims(claims) // This method sets the claims for the JWT token, which can include additional information about the user.
                 .setSubject(mail)// This method sets the subject of the JWT token, which is typically the user's email address.
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis()))
                 .signWith(getSigInKey()) // This method signs the JWT token using the signing key generated from the secret.
                    .compact(); // This method compacts the JWT token into a string format, making it ready for transmission or storage.


        }

}

