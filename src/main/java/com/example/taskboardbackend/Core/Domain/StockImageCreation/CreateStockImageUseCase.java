package com.example.taskboardbackend.Core.Domain.StockImageCreation;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.IdenticonAvatar;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CreateStockImageUseCase {

    public BufferedImage execute(String email) throws RuntimeException {
        Avatar avatar = IdenticonAvatar
                .newAvatarBuilder()
                .size(250,250)
                .build();
        return avatar.create(stringHashToLong(email));
    }

    private long stringHashToLong(String input) throws RuntimeException {
        try {
            return new BigInteger(1, MessageDigest
                    .getInstance("SHA-256")
                    .digest(input
                            .getBytes(StandardCharsets
                                    .UTF_8)))
                    .longValue();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
