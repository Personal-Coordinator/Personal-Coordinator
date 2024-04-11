package com.example.personalcoordinator.controller;

import com.example.personalcoordinator.dto.course.CourseDto;
import com.example.personalcoordinator.dto.course.CreateCourseRequestDto;
import com.example.personalcoordinator.dto.course.UpdateCourseStatusDto;
import com.example.personalcoordinator.dto.coursetask.AddTaskToCourseRequestDto;
import com.example.personalcoordinator.model.User;
import com.example.personalcoordinator.service.course.CourseService;
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
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @Operation(summary = "add course",
            description = "Return course if course is added")

    @PostMapping("/add")
    CourseDto addCourse(Authentication authentication,
                        @RequestBody CreateCourseRequestDto requestDto) {
        User user = (User) authentication.getPrincipal();
        return courseService.addCourse(user.getId(), requestDto);
    }

    @Operation(summary = "add course task",
            description = "Return course if course task is added")
    @PostMapping("/add/{id}")
    CourseDto addCourseTask(Authentication authentication,
                        @RequestBody AddTaskToCourseRequestDto requestDto, @PathVariable Long id) {
        User user = (User) authentication.getPrincipal();
        return courseService.addCourseTasksByUserId(user.getId(), requestDto, id);
    }

    @Operation(summary = "Get all courses",
            description = "Return all courses for the current user")
    @GetMapping("/all")
    List<CourseDto> getAllCourses(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return courseService.findAllCourses(user.getId());
    }

    @Operation(summary = "Update course status")
    @PatchMapping("/{id}")
    CourseDto updateCourseStatus(@RequestBody UpdateCourseStatusDto requestDto,
                                @PathVariable Long id) {
        return courseService.updateCourseStatus(requestDto, id);
    }

    @Operation(summary = "Delete course")
    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

}
