package com.example.personalcoordinator.dto.course;

public record CreateCourseRequestDto(
        String name,
        String description,
        String link,
        String image
) {
}
