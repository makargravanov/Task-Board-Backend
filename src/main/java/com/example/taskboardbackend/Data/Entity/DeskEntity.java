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
@Table(name = "Desks")
public class DeskEntity {
    @Id
    private Long id;
    @OneToMany
    private Set<StateEntity> states;
    @OneToMany
    private Set<UserDeskAccessEntity> deskAccesses;
    private String title;
    private String description;
    private String color;
    private int type;
    private LocalDateTime createdAt;
}
