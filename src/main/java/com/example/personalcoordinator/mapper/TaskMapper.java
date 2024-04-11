package com.example.personalcoordinator.mapper;

import com.example.personalcoordinator.config.MapperConfig;
import com.example.personalcoordinator.dto.task.TaskDto;
import com.example.personalcoordinator.model.Task;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(config = MapperConfig.class)
@Component
public interface TaskMapper {

    @Mapping(target = "userId", source = "user.id")
    TaskDto toDto(Task task);

    Task toModel(TaskDto taskDto);

    @Named("taskFromId")
    default Task taskFromId(Long id) {
        return Optional.ofNullable(id)
                .map(Task::new)
                .orElse(null);
    }
}
