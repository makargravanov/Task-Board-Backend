package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.UserDeskAccessRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeskAccessCRUD {
    private final UserDeskAccessRepository userDeskAccessRepository;

    public UserDeskAccessCRUD(UserDeskAccessRepository userDeskAccessRepository) {
        this.userDeskAccessRepository = userDeskAccessRepository;
    }
}
