package com.example.personalcoordinator.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserRegistrationRequestDto {
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Length(min = 8, max = 35)
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
