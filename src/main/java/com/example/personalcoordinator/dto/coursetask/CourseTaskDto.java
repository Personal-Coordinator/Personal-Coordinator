package com.example.personalcoordinator.dto.coursetask;

import com.example.personalcoordinator.model.Status;

public record CourseTaskDto(
        Long id,
        Long taskId,
        String taskName,
        Status status
){
}
