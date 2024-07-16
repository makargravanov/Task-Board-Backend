package com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserSpaceAccessEntity spaceAccess;
    private int accessLevel;
    @ManyToMany(mappedBy = "userDeskAccesses")
    private Set<TaskEntity> tasks;
}
