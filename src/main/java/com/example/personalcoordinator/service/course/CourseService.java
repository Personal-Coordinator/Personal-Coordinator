package com.example.personalcoordinator.service.course;

import com.example.personalcoordinator.dto.course.CourseDto;
import com.example.personalcoordinator.dto.course.CreateCourseRequestDto;
import com.example.personalcoordinator.dto.course.DeleteDto;
import com.example.personalcoordinator.dto.course.UpdateCourseDto;
import com.example.personalcoordinator.dto.coursetask.AddTaskToCourseByInitialsRequestDto;
import java.util.List;

public interface CourseService {

    CourseDto getCourseByUserIdAndCourseId(Long userId, Long courseId);

    CourseDto addCourse(Long userId, CreateCourseRequestDto createCourseRequestDto);

    CourseDto addCourseTasksByUserId(Long userId, AddTaskToCourseByInitialsRequestDto requestDto,
                                     Long courseId);

    CourseDto updateCourseStatus(UpdateCourseDto updateCourseStatusDto, Long courseId);

    List<CourseDto> findAllCourses(Long userId);

    CourseDto findCourseById(Long courseId);

    DeleteDto deleteCourse(Long courseId);

    Long deleteCourseTask(Long courseId,Long taskId);
}
