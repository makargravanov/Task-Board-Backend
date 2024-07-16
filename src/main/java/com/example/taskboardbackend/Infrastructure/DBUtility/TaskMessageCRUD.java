package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.TaskMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskMessageCRUD {
    private final TaskMessageRepository taskMessageRepository;

    public TaskMessageCRUD(TaskMessageRepository taskMessageRepository) {
        this.taskMessageRepository = taskMessageRepository;
    }
}
