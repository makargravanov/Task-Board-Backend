package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskCRUD {
    private final TaskRepository taskRepository;

    public TaskCRUD(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
