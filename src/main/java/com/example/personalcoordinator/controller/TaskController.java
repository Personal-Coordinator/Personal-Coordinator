package com.example.personalcoordinator.controller;

import com.example.personalcoordinator.dto.task.CreateTaskRequestDto;
import com.example.personalcoordinator.dto.task.TaskDto;
import com.example.personalcoordinator.dto.task.UpdateTaskStatusDto;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.service.task.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Operation(summary = "add task",
            description = "Return task if task is added")
    @PostMapping
    TaskDto addTask(Authentication authentication,
                       @RequestBody CreateTaskRequestDto requestDto) {
        User user = (User) authentication.getPrincipal();
        return taskService.create(user.getId(), requestDto);
    }

    @Operation(summary = "Get all tasks",
            description = "Return all tasks for the current user")
    @GetMapping
    List<TaskDto> getAllTasks(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return taskService.findAll(user.getId());
    }

    @Operation(summary = "Update task status")
    @PatchMapping("/{id}")
    TaskDto updateTaskStatus(@RequestBody UpdateTaskStatusDto requestDto,
                               @PathVariable Long id) {
        return taskService.update(requestDto, id);
    }

    @Operation(summary = "Delete task")
    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }

}
