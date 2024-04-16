package com.example.personalcoordinator.service.task;

import com.example.personalcoordinator.dto.task.CreateTaskRequestDto;
import com.example.personalcoordinator.dto.task.TaskDto;
import com.example.personalcoordinator.dto.task.UpdateTaskStatusDto;
import com.example.personalcoordinator.mapper.TaskMapper;
import com.example.personalcoordinator.model.Status;
import com.example.personalcoordinator.model.Task;
import com.example.personalcoordinator.repository.TaskRepository;
import com.example.personalcoordinator.service.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserService userService;

    @Transactional
    @Override
    public TaskDto create(Long userId, CreateTaskRequestDto requestDto) {
        Task task = createTask(userId, requestDto);
        task.setUser(userService.getById(userId));
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> findAll(Long userId) {
        return taskRepository.findAllByUserId(userId).stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public TaskDto update(UpdateTaskStatusDto requestDto, Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task not found"));
        task.setStatus(requestDto.status());
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    private Task createTask(Long userId, CreateTaskRequestDto requestDto) {
        Task task = new Task();
        task.setUser(userService.getById(userId));
        task.setName(requestDto.name());
        task.setStatus(Status.NOT_STARTED);
        return task;
    }

}
