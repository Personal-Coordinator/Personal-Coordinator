package com.example.personalcoordinator.repository;

import com.example.personalcoordinator.model.Status;
import com.example.personalcoordinator.model.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT o FROM Task o "
            + "LEFT join fetch o.user u "
            + "WHERE u.id = :userId")
    List<Task> findAllByUserId(Long userId);

    @Query("SELECT o FROM Task o "
            + "LEFT join fetch o.user u "
            + "WHERE u.id = :userId AND o.status = :status")
    List<Task> findAllCompletedTasks(Long userId, Status status);

}
