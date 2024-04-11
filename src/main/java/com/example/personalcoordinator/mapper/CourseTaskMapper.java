package com.example.personalcoordinator.mapper;

import com.example.personalcoordinator.config.MapperConfig;
import com.example.personalcoordinator.dto.coursetask.AddTaskToCourseRequestDto;
import com.example.personalcoordinator.dto.coursetask.CourseTaskDto;
import com.example.personalcoordinator.dto.coursetask.UpdateCourseTaskById;
import com.example.personalcoordinator.model.CourseTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = TaskMapper.class)
public interface CourseTaskMapper {
    @Mapping(target = "taskId", source = "task.id")
    @Mapping(target = "taskName", source = "task.name")
    CourseTaskDto toDto(CourseTask courseTask);

    @Mapping(target = "task", source = "taskId", qualifiedByName = "taskFromId")
    CourseTask toModel(AddTaskToCourseRequestDto requestDto);

    @Mapping(target = "task", ignore = true)
    void update(UpdateCourseTaskById requestDto, @MappingTarget CourseTask itemFromDb);

}
