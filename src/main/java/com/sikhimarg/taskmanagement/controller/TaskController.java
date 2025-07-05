package com.sikhimarg.taskmanagement.controller;

import com.sikhimarg.taskmanagement.dto.CreateTaskRequest;
import com.sikhimarg.taskmanagement.dto.TaskDto;
import com.sikhimarg.taskmanagement.dto.UpdateTaskRequest;
import com.sikhimarg.taskmanagement.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                     // Markiert diese Klasse als REST-Controller
@RequestMapping("/api/tasks")       // Basis-URL für alle Endpunkte dieser Klasse
public class TaskController {
    private final TaskService taskService;

    // Konstruktor-Injektion für TaskService
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Aufgabe erstellen
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody CreateTaskRequest request) {
        TaskDto created = taskService.createTask(request);
        return ResponseEntity.ok(created);
    }
    // Alle Aufgaben abrufen
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> allTasks = taskService.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }

    // Einzelne Aufgabe per ID abrufen
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        TaskDto task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    // Aufgabe aktualisieren
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable Long id,
            @RequestBody UpdateTaskRequest request){
        TaskDto updated = taskService.updateTask(id, request);
        return ResponseEntity.ok(updated);
    }

    // Aufgabe löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); // HTTP 204: Kein Inhalt zurück
    }

    // Nur Status "erledigt" ändern (PUT mit Boolean-Query-Param)
    @PutMapping("/{id}/status")
    public ResponseEntity<TaskDto> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean erledigt){
        TaskDto updated = taskService.updateStatus(id, erledigt);
        return ResponseEntity.ok(updated);
    }
}
