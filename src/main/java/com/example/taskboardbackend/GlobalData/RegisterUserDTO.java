package com.example.taskboardbackend.GlobalData;

public record RegisterUserDTO(String firstName,
                              String middleName,
                              String lastName,
                              Boolean gender,
                              Integer grade,
                              Integer group,
                              String email,
                              String password) {

}
