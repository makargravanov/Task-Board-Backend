package com.example.taskboardbackend.Data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserSpaceAccess")
public class UserSpaceAccessEntity {
    @Id
    private Long id;
    @ManyToOne
    private UserEntity userId;
    private int accessLevel;
}
