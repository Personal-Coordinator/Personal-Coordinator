package com.example.personalcoordinator.dto.task;

import com.example.personalcoordinator.model.Status;

public record TaskDto(
        Long id,
        Long userId,
        String name,
        Status status
) {
}
