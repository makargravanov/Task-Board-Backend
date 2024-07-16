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
@Table(name = "TaskMessages")
public class TaskMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserDeskAccessEntity senderDeskAccess;
    @ManyToOne
    private TaskEntity task;
    private String text;
    @Lob
    private byte[] file; //TODO: replace with S3
    private LocalDateTime createdAt;
}
