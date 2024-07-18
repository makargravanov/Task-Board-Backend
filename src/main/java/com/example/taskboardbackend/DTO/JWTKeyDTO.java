package com.example.taskboardbackend.DTO;

import java.time.LocalDateTime;

public record JWTKeyDTO(Long id,
                        String key,
                        LocalDateTime createdAt,
                        LocalDateTime expiresAt) {
}
