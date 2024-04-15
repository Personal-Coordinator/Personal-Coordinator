package com.example.personalcoordinator.service.defaultcourse;

import com.example.personalcoordinator.dto.defaultcourse.DefaultCourseResponseDto;
import java.util.List;

public interface DefaultCourseService {
    List<DefaultCourseResponseDto> getDefaultCourses();
}
