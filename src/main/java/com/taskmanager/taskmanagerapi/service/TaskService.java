package com.taskmanager.taskmanagerapi.service;

import com.taskmanager.taskmanagerapi.dto.TaskDTO;
import com.taskmanager.taskmanagerapi.entity.Task;
import com.taskmanager.taskmanagerapi.entity.User;
import com.taskmanager.taskmanagerapi.repository.TaskRepository;
import com.taskmanager.taskmanagerapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TaskDTO create(TaskDTO dto, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Task task = modelMapper.map(dto, Task.class);
        task.setUser(user);
        Task saved = taskRepository.save(task);
        return modelMapper.map(saved, TaskDTO.class);
    }

    public List<TaskDTO> getByUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return taskRepository.findByUserId(user.getId()).stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    public TaskDTO update(Long id, TaskDTO dto, String username) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (!task.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Acesso negado");
        }
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        Task updated = taskRepository.save(task);
        return modelMapper.map(updated, TaskDTO.class);
    }

    public void delete(Long id, String username) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (!task.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Acesso negado");
        }
        taskRepository.delete(task);
    }
}