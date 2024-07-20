package com.example.taskboardbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;


class TaskBoardBackendApplicationTests {

    @Test
    void createModuleDocumentation() {
        ApplicationModules modules = ApplicationModules.of(TaskBoardBackendApplication.class);
        modules.forEach(System.out::println);
    }
}
