package com.example.taskboardbackend.GlobalData;

/**
 * Это пример создания immutable DTO при помощи Record.
 * Убраны поля:
 * String email
 * String password,
 * как поля, содержащие, допустим, личную информацию.
 * Также, убраны поля:
 * LocalDateTime createdAt
 * boolean gender,
 * так как данные поля, по какой-либо причине, мы посчитали излишними, в конкретном случае.
 */


public record ExampleUserDTO(Long id,
                             String firstName,
                             String middleName,
                             String lastName,
                             int accessLevel,
                             int grade,
                             byte[] image) {

}
