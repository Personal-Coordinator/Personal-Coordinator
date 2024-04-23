package com.example.personalcoordinator.repository;

import com.example.personalcoordinator.model.CourseTask;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseTasksRepository extends JpaRepository<CourseTask, Long> {
    @Query("SELECT c FROM CourseTask c WHERE c.course.id = :courseId AND c.task.id = :taskId")
    CourseTask deleteTaskCourseId(Long courseId, Long taskId);

    void deleteAllByCourseId(Long courseId);

    List<CourseTask> findAllByCourseId(Long courseId);
}
