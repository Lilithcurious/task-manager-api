package com.taskmanager.taskmanagerapi.repository;

import com.taskmanager.taskmanagerapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}