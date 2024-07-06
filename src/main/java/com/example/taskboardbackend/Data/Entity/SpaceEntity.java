package com.example.taskboardbackend.Data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "Spaces")
public class SpaceEntity {
    @Id
    private Long id;
    private String title;
    @OneToMany
    private Set<DeskEntity> desks;
    @OneToMany
    private Set<UserSpaceAccessEntity> spaceAccesses;
    private LocalDateTime createdAt;
}
