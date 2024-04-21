package com.example.personalcoordinator.service.userprofile;

import com.example.personalcoordinator.dto.userprofile.UserProfileDto;

public interface UserProfileService {
    UserProfileDto getUserProfile(Long userId);
}
