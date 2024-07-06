package com.example.taskboardbackend.Data.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "States")
public class StateEntity {
    @Id
    private Long id;
    private String title;
    private String color;
    private Long orderIndex;
    @OneToMany
    private Set<TaskEntity> tasks;
    private boolean isProtected;
}