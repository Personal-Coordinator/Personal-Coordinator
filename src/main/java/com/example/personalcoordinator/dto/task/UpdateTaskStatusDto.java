package com.example.personalcoordinator.dto.task;

import com.example.personalcoordinator.model.Status;

public record UpdateTaskStatusDto(
        String name,
        Status status
) {
}
