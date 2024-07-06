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
@Table(name = "UserDeskAccess")
public class UserDeskAccessEntity {
    @Id
    private Long id;
    @ManyToOne
    private UserSpaceAccessEntity spaceAccessId;
    private int accessLevel;
    @ManyToMany(mappedBy = "userDeskAccesses")
    private Set<TaskEntity> tasks;
}
