package com.example.personalcoordinator.controller;

import com.example.personalcoordinator.dto.userprofile.UserProfileDto;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.service.userprofile.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/user-profile")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @Operation(summary = "Return user profile",
            description = "Return user profile for the current user")
    @GetMapping
    UserProfileDto getUserProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return userProfileService.getUserProfile(user.getId());
    }
}
