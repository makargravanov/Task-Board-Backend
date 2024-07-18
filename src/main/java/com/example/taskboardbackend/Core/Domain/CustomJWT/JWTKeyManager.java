package com.example.taskboardbackend.Core.Domain.CustomJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class JWTKeyManager {
    @Value("${jwt_old_key}")
    private String oldKey;
    @Value("${jwt_old_key_close_time}")
    private LocalDateTime oldKeyCloseTime;
    @Value("${jwt_actual_key}")
    private String actualKey;
    @Value("${jwt_actual_key_open_time}")
    private LocalDateTime actualKeyOpenTime;

    private void generateKey() {
        if(actualKey.equals("JWT_ACTUAL_KEY") || actualKey.isEmpty()){
            byte[] bytes = new byte[32];
            new SecureRandom().nextBytes(bytes);
            actualKey= new BigInteger(1, bytes).toString(16);
            actualKeyOpenTime=LocalDateTime.now();
        }else{
            oldKey=actualKey;
            oldKeyCloseTime=actualKeyOpenTime.plusMinutes(30);
            byte[] bytes = new byte[32];
            new SecureRandom().nextBytes(bytes);
            actualKey= new BigInteger(1, bytes).toString(16);
            actualKeyOpenTime=LocalDateTime.now();
        }

    }

}
