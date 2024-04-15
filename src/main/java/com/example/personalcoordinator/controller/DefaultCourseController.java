package com.example.personalcoordinator.controller;

import com.example.personalcoordinator.dto.defaultcourse.DefaultCourseResponseDto;
import com.example.personalcoordinator.service.defaultcourse.DefaultCourseService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/default-course")
public class DefaultCourseController {
    private final DefaultCourseService defaultCourseService;

    @Operation(summary = "Get all default  courses",
            description = "Return all courses for the current user")
    @GetMapping("/all")
    List<DefaultCourseResponseDto> getAllCourses() {
        return defaultCourseService.getDefaultCourses();
    }
}
