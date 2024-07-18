package com.example.taskboardbackend.Core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final ThreadPoolTaskExecutor taskExecutor;

    public ScheduledTasks(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Выполнение задачи каждый день в полночь
    public void performTask1() {
        taskExecutor.execute(() -> {
            // Ваша задача здесь
            System.out.println("Task 1 executed in thread: " + Thread.currentThread().getName());
        });
    }

    @Scheduled(cron = "0 0 12 * * ?") // Выполнение задачи каждый день в полдень
    public void performTask2() {
        taskExecutor.execute(() -> {
            // Ваша задача здесь
            System.out.println("Task 2 executed in thread: " + Thread.currentThread().getName());
        });
    }
}
