package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.TFATokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TFATokenCRUD {
    private final TFATokenRepository tfaTokenRepository;

    public TFATokenCRUD(TFATokenRepository tfaTokenRepository) {
        this.tfaTokenRepository = tfaTokenRepository;
    }
}
