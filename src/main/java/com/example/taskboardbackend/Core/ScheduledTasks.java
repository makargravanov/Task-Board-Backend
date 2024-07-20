package com.example.taskboardbackend.Core;

import com.example.taskboardbackend.GlobalData.ConcurrentJWTKeys;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final ThreadPoolTaskExecutor taskExecutor;
    private final ConcurrentJWTKeys concurrentJWTKeys;

    public ScheduledTasks(ThreadPoolTaskExecutor taskExecutor, ConcurrentJWTKeys concurrentJWTKeys) {
        this.taskExecutor = taskExecutor;
        this.concurrentJWTKeys = concurrentJWTKeys;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Выполнение задачи каждый день в полночь
    public void refreshKeysTask() {
        taskExecutor.execute(() -> {
            concurrentJWTKeys.refreshKeys();
            System.out.println("Task 1 executed in thread: " + Thread.currentThread().getName());
        });
    }
}
