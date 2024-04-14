package com.example.personalcoordinator.repository;

import com.example.personalcoordinator.model.CourseTask;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseTasksRepository extends JpaRepository<CourseTask, Long> {
    @Modifying
    @Query("DELETE FROM CourseTask c WHERE c.course.id = :courseId")
    void deleteByCourseId(Long courseId);

    void deleteAllByCourseId(Long courseId);

    List<CourseTask> findAllByCourseId(Long courseId);
}
