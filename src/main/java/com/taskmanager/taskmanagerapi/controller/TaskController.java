package com.taskmanager.taskmanagerapi.controller;

import com.taskmanager.taskmanagerapi.dto.TaskDTO;
import com.taskmanager.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO, Authentication auth) {
        TaskDTO created = taskService.create(taskDTO, auth.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll(Authentication auth) {
        return ResponseEntity.ok(taskService.getByUser(auth.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO, Authentication auth) {
        return ResponseEntity.ok(taskService.update(id, taskDTO, auth.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Authentication auth) {
        taskService.delete(id, auth.getName());
        return ResponseEntity.noContent().build();
    }
}

