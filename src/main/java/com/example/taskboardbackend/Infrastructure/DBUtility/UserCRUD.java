package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCRUD {
    private final UserRepository userRepository;
    public UserCRUD(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
