package com.example.taskboardbackend.Data.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tasks")
public class TaskEntity {
    @Id
    private Long id;
    private Long orderIndex;
    private String title;
    private String description;
    private int priority;
    private int maxParticipants;
    private LocalDateTime deadline;
    @ManyToOne
    private UserEntity creatorUserId;
    private String color;
    private float score; //TODO: Уточнить тип
    private boolean isCompleted;
    private boolean isProtected;
    private LocalDateTime createdAt;
    @ManyToMany
    @JoinTable(
            name = "UserTaskParticipation",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "desk_access_id"))
    private Set<UserDeskAccessEntity> userDeskAccesses;
}
