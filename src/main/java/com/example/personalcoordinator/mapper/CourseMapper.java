package com.example.personalcoordinator.mapper;

import com.example.personalcoordinator.config.MapperConfig;
import com.example.personalcoordinator.dto.course.CourseDto;
import com.example.personalcoordinator.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(config = MapperConfig.class, uses = CourseTaskMapper.class)
@Component
public interface CourseMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "courseTasks", target = "courseTasks")
    CourseDto toDto(Course course);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "courseTasks", target = "courseTasks")
    Course toModel(CourseDto courseDto);
}
