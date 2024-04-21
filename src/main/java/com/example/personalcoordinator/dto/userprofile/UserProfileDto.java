package com.example.personalcoordinator.dto.userprofile;

public record UserProfileDto(
        Long id,
        String name,
        String email,
        int completedTasks,
        int totalTasks
) {
}
