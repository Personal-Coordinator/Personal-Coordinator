package com.example.personalcoordinator.mapper;

import com.example.personalcoordinator.config.MapperConfig;
import com.example.personalcoordinator.dto.task.TaskDto;
import com.example.personalcoordinator.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(config = MapperConfig.class)
@Component
public interface TaskMapper {

    @Mapping(target = "userId", source = "user.id")
    TaskDto toDto(Task task);

    Task toModel(TaskDto taskDto);
}
