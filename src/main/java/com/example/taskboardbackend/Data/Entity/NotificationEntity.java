package com.example.taskboardbackend.Data.Entity;

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
    private Long id;
    @ManyToOne
    private UserEntity userId;
    @ManyToOne
    private TaskEntity taskId;
    private String title;
    private String text;
    private LocalDateTime createdAt;
}