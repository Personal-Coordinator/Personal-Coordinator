package com.example.personalcoordinator.service.task;

import com.example.personalcoordinator.dto.task.CreateTaskRequestDto;
import com.example.personalcoordinator.dto.task.TaskDto;
import com.example.personalcoordinator.dto.task.UpdateTaskStatusDto;
import java.util.List;

public interface TaskService {

    TaskDto create(Long userId, CreateTaskRequestDto requestDto);

    List<TaskDto> findAll(Long userId);

    TaskDto update(UpdateTaskStatusDto requestDto, Long orderId);

    int countCompletedUserTasks(Long userId);

    int countAllUserTasks(Long userId);

    void deleteById(Long id);
}
