package com.example.personalcoordinator.dto.coursetask;

public record CourseTaskDto(
        Long id,
        Long taskId,
        String taskName,
        String taskDescription
){
}
