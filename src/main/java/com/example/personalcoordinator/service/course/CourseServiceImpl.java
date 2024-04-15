package com.example.personalcoordinator.service.course;

import com.example.personalcoordinator.dto.course.CourseDto;
import com.example.personalcoordinator.dto.course.CreateCourseRequestDto;
import com.example.personalcoordinator.dto.course.DeleteDto;
import com.example.personalcoordinator.dto.course.UpdateCourseStatusDto;
import com.example.personalcoordinator.dto.coursetask.AddTaskToCourseByInitialsRequestDto;
import com.example.personalcoordinator.dto.coursetask.AddTaskToCourseRequestDto;
import com.example.personalcoordinator.dto.task.CreateTaskRequestDto;
import com.example.personalcoordinator.dto.task.TaskDto;
import com.example.personalcoordinator.mapper.CourseMapper;
import com.example.personalcoordinator.mapper.CourseTaskMapper;
import com.example.personalcoordinator.model.Course;
import com.example.personalcoordinator.model.CourseTask;
import com.example.personalcoordinator.model.Status;
import com.example.personalcoordinator.repository.CourseRepository;
import com.example.personalcoordinator.repository.CourseTasksRepository;
import com.example.personalcoordinator.repository.UserRepository;
import com.example.personalcoordinator.service.task.TaskService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseMapper courseMapper;
    private final CourseTaskMapper courseTaskMapper;
    private final CourseTasksRepository courseTaskRepository;
    private final TaskService taskService;

    @Override
    public CourseDto getCourseByUserIdAndCourseId(Long userId, Long courseId) {
        return courseRepository.findByUserIdAndCourseId(userId, courseId).stream()
                .findFirst()
                .map(courseMapper::toDto)
                .orElseThrow(() -> new IllegalStateException("Course not found"));
    }

    @Transactional
    @Override
    public CourseDto addCourse(Long userId,CreateCourseRequestDto createCourseRequestDto) {
        Course course = createCourse(userId, createCourseRequestDto);
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @Override
    public CourseDto addCourseTasksByUserId(Long userId,
                                            AddTaskToCourseByInitialsRequestDto initialsRequestDto,
                                            Long courseId) {
        CourseDto courseDto = getCourseByUserIdAndCourseId(userId, courseId);
        CreateTaskRequestDto createTaskRequestDto =
                new CreateTaskRequestDto(initialsRequestDto.name(),
                initialsRequestDto.description());
        TaskDto taskDto = taskService.create(userId, createTaskRequestDto);
        AddTaskToCourseRequestDto requestDto = new AddTaskToCourseRequestDto(taskDto.id());
        CourseTask courseTask = courseTaskMapper.toModel(requestDto);
        courseTask.setCourse(courseMapper.toModel(courseDto));
        courseTaskRepository.save(courseTask);
        return courseMapper.toDto(courseMapper.toModel(courseDto));
    }

    @Override
    public CourseDto updateCourseStatus(UpdateCourseStatusDto updateCourseStatusDto,
                                        Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException("Course not found"));
        course.setStatus(updateCourseStatusDto.status());
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @Override
    public List<CourseDto> findAllCourses(Long userId) {
        return courseRepository.findAllByUserId(userId).stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @Override
    public DeleteDto deleteCourse(Long courseId) {
        List<CourseTask> courseTasks = courseTaskRepository.findAllByCourseId(courseId);
        courseTasks.forEach(courseTask -> {
            taskService.deleteById(courseTask.getTask().getId());
        });
        courseRepository.deleteById(courseId);
        return new DeleteDto(courseId);
    }

    private Course createCourse(Long userId, CreateCourseRequestDto requestDto) {
        Course course = new Course();
        course.setUser(userRepository.getById(userId));
        course.setName(requestDto.name());
        course.setDescription(requestDto.description());
        course.setStatus(Status.IN_PROGRESS);
        course.setLink(requestDto.link());
        course.setStartDate(LocalDateTime.now());
        course.setImage(requestDto.image());
        return course;
    }

    private void deleteCourseTasks(Long courseId) {
        courseTaskRepository.deleteAllByCourseId(courseId);
    }
}
