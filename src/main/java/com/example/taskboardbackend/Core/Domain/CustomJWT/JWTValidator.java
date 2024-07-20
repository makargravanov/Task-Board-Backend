package com.example.taskboardbackend.Core.Domain.CustomJWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.taskboardbackend.GlobalData.ConcurrentJWTKeys;
import com.example.taskboardbackend.GlobalData.ConcurrentPair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class JWTValidator {
    private final ConcurrentJWTKeys jwtKeys;

    public JWTValidator(ConcurrentJWTKeys jwtKeys) {
        this.jwtKeys = jwtKeys;
    }

    private Long secondInternal(String jwt){
        try {
            DecodedJWT decodedJWT = JWT
                    .require(Algorithm.HMAC256(jwtKeys.getOldKey()))
                    .build()
                    .verify(jwt);
            LocalDateTime expirationDateTime = LocalDateTime
                    .ofInstant(decodedJWT
                                    .getExpiresAt()
                                    .toInstant(),
                            ZoneId
                                    .systemDefault());
            if (jwtKeys.getTimeOfOld().isAfter(expirationDateTime)) {
                return Long.valueOf(decodedJWT.getId());
            } else {
                return null;
            }
        } catch (JWTVerificationException | NullPointerException | NumberFormatException e) {
            return null;
        }
    }
    private Long internal(String jwt) {
        try {
            DecodedJWT decodedJWT = JWT
                    .require(Algorithm
                            .HMAC256(jwtKeys
                                    .getActualKey()))
                    .build()
                    .verify(jwt);
            return Long.valueOf(decodedJWT.getId());
        } catch (JWTVerificationException | NullPointerException | NumberFormatException e) {
            return secondInternal(jwt);
        }
    }

    public boolean validate(String token){
        return internal(token) != null;
    }

    public Long getIdFromToken(String token){
        Long l = internal(token);
        if(l==null){
            throw new NullPointerException("Invalid token with no Id");
        }else {
            return l;
        }
    }

}
