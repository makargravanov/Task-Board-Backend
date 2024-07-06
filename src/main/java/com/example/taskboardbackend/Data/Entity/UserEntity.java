package com.example.taskboardbackend.Data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Table(name = "Users")
public class UserEntity {
    @Id
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean gender;
    private String email;
    private String password;
    private int accessLevel;
    private int grade;
    private LocalDateTime createdAt;
    @Lob
    private byte[] image;
}
