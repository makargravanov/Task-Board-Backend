package com.example.taskboardbackend.GlobalData;

import java.time.LocalDateTime;

public record JWTKeyDTO(Long id,
                        String key,
                        LocalDateTime createdAt,
                        LocalDateTime expiresAt) {
}
