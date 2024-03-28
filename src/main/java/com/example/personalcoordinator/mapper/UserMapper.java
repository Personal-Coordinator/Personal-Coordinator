package com.example.personalcoordinator.mapper;

import com.example.personalcoordinator.config.MapperConfig;
import com.example.personalcoordinator.dto.user.UserRegistrationRequestDto;
import com.example.personalcoordinator.dto.user.UserResponseDto;
import com.example.personalcoordinator.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = MapperConfig.class)
@Component
public interface UserMapper {
    User toModel(UserRegistrationRequestDto registrationRequestDto);

    UserResponseDto toDto(User user);
}
