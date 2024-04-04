package com.example.personalcoordinator.security;

import com.example.personalcoordinator.dto.user.UserLoginRequestDto;
import com.example.personalcoordinator.dto.user.UserLoginResponseDto;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token, findUserByEmail(authentication.getName()));
    }

    private String findUserByEmail(String email) {
        User byEmail = userService.getByEmail(email);
        return byEmail.getFirstName();
    }
}
