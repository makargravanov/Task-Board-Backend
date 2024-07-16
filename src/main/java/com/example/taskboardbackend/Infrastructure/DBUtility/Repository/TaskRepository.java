package com.example.taskboardbackend.Infrastructure.DBUtility.Repository;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
