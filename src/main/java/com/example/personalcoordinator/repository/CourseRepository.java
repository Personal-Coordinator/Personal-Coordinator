package com.example.personalcoordinator.repository;

import com.example.personalcoordinator.model.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT o FROM Course o "
            + "LEFT join fetch o.user u "
            + "WHERE u.id = :userId")
    List<Course> findAllByUserId(Long userId);

    @Query("SELECT c FROM Course c "
            + "LEFT join fetch c.user u "
            + "LEFT join fetch c.courseTasks o "
            + "LEFT join fetch o.task "
            + "WHERE u.id = :userId AND c.id = :courseId")
    List<Course> findByUserIdAndCourseId(Long userId, Long courseId);
}
