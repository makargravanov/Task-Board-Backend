package com.example.taskboardbackend.Infrastructure.DBUtility.Repository;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.TaskMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMessageRepository extends JpaRepository<TaskMessageEntity, Long> {
}
