package com.example.taskboardbackend.Infrastructure.DBUtility.Repository;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.DisallowedJWTEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisallowedJWTRepository extends JpaRepository<DisallowedJWTEntity, Long> {
}
