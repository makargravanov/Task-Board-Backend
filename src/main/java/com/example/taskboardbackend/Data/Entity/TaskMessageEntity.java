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
@Table(name = "TaskMessages")
public class TaskMessageEntity {
    @Id
    private Long id;
    @ManyToOne
    private UserDeskAccessEntity senderDeskAccessId;
    @ManyToOne
    private TaskEntity taskId;
    private String text;
    @Lob
    private byte[] file; //TODO: replace with S3
    private LocalDateTime createdAt;
}
