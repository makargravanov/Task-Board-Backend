package com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private TaskEntity task;
    private String title;
    private String text;
    private LocalDateTime createdAt;
}