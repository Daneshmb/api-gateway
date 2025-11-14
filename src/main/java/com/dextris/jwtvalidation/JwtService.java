package com.dextris.jwtvalidation;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.security.Key;


@Configuration
public class JwtService {
    private static final String SECRET_KEY = "u7T8dPq9tU3fBvN6yJkLp4RzXv2aQs0wYxMdCn9rT0zPqL3sFv8tUb7yIj5Kp2dE";

    //  Validate the token
    public void isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) getKey()) // verify the signature
                    .build()
                    .parseSignedClaims(token); //  Use this instead of parseClaimsJwt
        } catch (Exception e) {
            throw new RuntimeException("Invalid JWT token: " + e.getMessage());
        }
    }


    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }




//        //  Validate token
//        public void isTokenValid(String token){
//            Jwts.parser().setSigningKey(getKey()).build().parseClaimsJwt(token);
//        }
//
//        private Key getKey() {
//            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//            return Keys.hmacShaKeyFor(keyBytes);
//        }
    }

