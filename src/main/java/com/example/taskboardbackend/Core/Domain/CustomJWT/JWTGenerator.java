package com.example.taskboardbackend.Core.Domain.CustomJWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.taskboardbackend.GlobalData.ConcurrentJWTKeys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JWTGenerator {
    private final ConcurrentJWTKeys jwtKeys;
    @Value("${jwt.lifetime}")
    private Integer jwtLifetime;

    public JWTGenerator(ConcurrentJWTKeys jwtKeys) {
        this.jwtKeys = jwtKeys;
    }
    public String generate(Long userId){
        Instant now = Instant.now();
        Instant exp = now.plus(jwtLifetime, ChronoUnit.MINUTES);

        return JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(exp))
                .sign(Algorithm.HMAC256(jwtKeys.getActualKey()));
    }
}
