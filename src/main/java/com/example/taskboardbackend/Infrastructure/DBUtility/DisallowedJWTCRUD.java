package com.example.taskboardbackend.Infrastructure.DBUtility;
import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.DisallowedJWTRepository;
import org.springframework.stereotype.Service;
@Service
public class DisallowedJWTCRUD {
    private final DisallowedJWTRepository disallowedJWTRepository;

    public DisallowedJWTCRUD(DisallowedJWTRepository disallowedJWTRepository) {
        this.disallowedJWTRepository = disallowedJWTRepository;
    }
}
