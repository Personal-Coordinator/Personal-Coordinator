package com.example.personalcoordinator.dto.course;

import com.example.personalcoordinator.dto.coursetask.CourseTaskDto;
import java.util.Set;

public record CourseDto(
        Long id,
        Long userId,
        String name,
        String description,
        String status,
        String startDate,
        String link,
        String image,
        Set<CourseTaskDto> courseTasks
) {
}
