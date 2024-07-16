package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.UserSpaceAccessRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSpaceAccessCRUD {
    private final UserSpaceAccessRepository userSpaceAccessRepository;

    public UserSpaceAccessCRUD(UserSpaceAccessRepository userSpaceAccessRepository) {
        this.userSpaceAccessRepository = userSpaceAccessRepository;
    }
}
