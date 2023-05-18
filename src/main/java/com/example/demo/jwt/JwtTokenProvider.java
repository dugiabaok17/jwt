package com.example.demo.jwt;

import com.example.demo.security.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private String JWT_SECRET = "duvanan";
    private int JWT_EXPIRATION = 86400000;

    //tao jwt tu thong tin tu user
    public String generateToken(CustomUserDetails customUserDetails) {
        Date now = new Date();
        Date dateExpired = new Date(now.getTime()+JWT_EXPIRATION);

        //Tao chuoi JWT tu username
        return Jwts.builder().setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();

    }

    public String getUserNameFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    //validate thong tin cua JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token).getBody();
        } catch (MalformedJwtException exception) {
            log.error("Invalid JWT Token");
        } catch (ExpiredJwtException exception) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException exception) {
            log.error("Unsupported Jwt Exception");
        } catch (IllegalArgumentException exception) {
            log.error("JWT claims string is empty");
        }
        return false;
    }
}
