package com.example.personalcoordinator.mapper;

import com.example.personalcoordinator.config.MapperConfig;
import com.example.personalcoordinator.dto.defaultcourse.DefaultCourseResponseDto;
import com.example.personalcoordinator.model.DefaultCourse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = MapperConfig.class)
@Component
public interface DefaultCourseMapper {
    DefaultCourseResponseDto toDto(DefaultCourse defaultCourse);
}
