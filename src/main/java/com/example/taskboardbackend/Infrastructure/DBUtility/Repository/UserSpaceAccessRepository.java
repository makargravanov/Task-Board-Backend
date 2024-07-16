package com.example.taskboardbackend.Infrastructure.DBUtility.Repository;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.UserSpaceAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpaceAccessRepository extends JpaRepository<UserSpaceAccessEntity, Long> {
}
