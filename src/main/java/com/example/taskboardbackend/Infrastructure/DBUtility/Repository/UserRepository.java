package com.example.taskboardbackend.Infrastructure.DBUtility.Repository;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
