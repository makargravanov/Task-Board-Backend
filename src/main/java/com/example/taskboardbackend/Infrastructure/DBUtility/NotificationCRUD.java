package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationCRUD {
    private final NotificationRepository notificationRepository;

    public NotificationCRUD(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
}
