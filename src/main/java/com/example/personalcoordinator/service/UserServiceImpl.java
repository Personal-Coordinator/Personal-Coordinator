package com.example.personalcoordinator.service;

import com.example.personalcoordinator.dto.user.UserRegistrationRequestDto;
import com.example.personalcoordinator.dto.user.UserResponseDto;
import com.example.personalcoordinator.exception.EntityNotFoundException;
import com.example.personalcoordinator.exception.RegistrationException;
import com.example.personalcoordinator.mapper.UserMapper;
import com.example.personalcoordinator.model.Role;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.repository.RoleRepository;
import com.example.personalcoordinator.repository.UserRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto registerUser(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(
                    "Can't register user - user with this email already exists!");
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        Role role = roleRepository.findByName(Role.RoleName.ROLE_USER);
        user.setRoles(Set.of(role));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find user by id=" + id));
    }
}
