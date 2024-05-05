package com.example.personalcoordinator.service.userprofile;

import com.example.personalcoordinator.dto.userprofile.UserProfileDto;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.service.task.TaskService;
import com.example.personalcoordinator.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final TaskService taskService;
    private final UserService userService;

    @Override
    public UserProfileDto getUserProfile(Long userId) {
        User user = userService.getById(userId);
        int allTasks = taskService.countAllUserTasks(userId);
        int completedTasks = taskService.countCompletedUserTasks(userId);
        return new UserProfileDto(userId, user.getFirstName(),
                user.getEmail(),completedTasks, allTasks);
    }
}
