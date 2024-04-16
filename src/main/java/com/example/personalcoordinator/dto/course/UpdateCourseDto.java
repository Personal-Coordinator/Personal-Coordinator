package com.example.personalcoordinator.dto.course;

import com.example.personalcoordinator.model.Status;

public record UpdateCourseDto(
        String name,
        String description,
        String link,
        Status status
) {
}
