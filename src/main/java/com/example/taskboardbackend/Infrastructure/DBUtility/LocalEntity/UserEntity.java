package com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean gender;//0-w,1-m
    private String email;
    private String password;
    private int accessLevel;
    private int grade;
    private int group;
    private boolean isEmailVerified;
    private boolean isTwoFactorAuth;
    private LocalDateTime createdAt;
    @OneToMany
    private Set<FileIdEntity> imageIdSet;
}
