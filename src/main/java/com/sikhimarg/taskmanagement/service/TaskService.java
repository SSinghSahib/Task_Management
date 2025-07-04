package com.sikhimarg.taskmanagement.service;

import com.sikhimarg.taskmanagement.dto.CreateTaskRequest;
import com.sikhimarg.taskmanagement.dto.TaskDto;
import com.sikhimarg.taskmanagement.dto.UpdateTaskRequest;

import java.util.List;

public interface TaskService {

    TaskDto createTask(CreateTaskRequest request);

    TaskDto getTaskById(Long id);

   List<TaskDto> getAllTasks();

   TaskDto updateTask(Long id, UpdateTaskRequest request);

   void deleteTask(Long id);

    // Neue Methode für Statusänderung
    TaskDto updateStatus(Long id, boolean erledigt);
}
