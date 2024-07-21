package com.example.taskboardbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskBoardBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskBoardBackendApplication.class, args);
    }

}
