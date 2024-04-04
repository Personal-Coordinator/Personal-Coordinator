package com.example.personalcoordinator.dto.user;

import lombok.Data;

@Data
public class UserRegistrationRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
