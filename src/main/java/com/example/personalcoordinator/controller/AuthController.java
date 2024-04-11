package com.example.personalcoordinator.controller;

import com.example.personalcoordinator.dto.user.CurrentUserResponseDto;
import com.example.personalcoordinator.dto.user.UserLoginRequestDto;
import com.example.personalcoordinator.dto.user.UserLoginResponseDto;
import com.example.personalcoordinator.dto.user.UserRegistrationRequestDto;
import com.example.personalcoordinator.dto.user.UserResponseDto;
import com.example.personalcoordinator.exception.RegistrationException;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.security.AuthenticationService;
import com.example.personalcoordinator.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Operation(summary = "Login",
            description = "Return token and user name if user is authenticated")
    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @Operation(summary = "Register",
            description = "Return user if user is registered")
    @PostMapping("/register")
    public UserResponseDto registerUser(@RequestBody UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.registerUser(requestDto);
    }

    @Operation(summary = "Return current user",
            description = "Return current user name")
    @GetMapping("/current-user")
    public CurrentUserResponseDto returnCurrentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return new CurrentUserResponseDto(user.getFirstName());
    }

    @Operation(summary = "Delete user by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
