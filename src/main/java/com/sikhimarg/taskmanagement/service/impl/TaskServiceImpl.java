package com.sikhimarg.taskmanagement.service.impl;

import com.sikhimarg.taskmanagement.dto.CreateTaskRequest;
import com.sikhimarg.taskmanagement.dto.TaskDto;
import com.sikhimarg.taskmanagement.dto.UpdateTaskRequest;
import com.sikhimarg.taskmanagement.entity.Task;
import com.sikhimarg.taskmanagement.entity.User;
import com.sikhimarg.taskmanagement.exception.NotFoundException;
import com.sikhimarg.taskmanagement.mapper.TaskMapper;
import com.sikhimarg.taskmanagement.repository.TaskRepository;
import com.sikhimarg.taskmanagement.repository.UserRepository;
import com.sikhimarg.taskmanagement.service.TaskService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;  // Zugriff auf die Datenbank (für Tasks)
        this.userRepository = userRepository;  // Zugriff auf Benutzer (für Zuordnung)
        this.taskMapper = taskMapper;         // Für Umwandlung: Entity ⇄ DTO
    }
    // Neue Aufgabe erstellen
    @Override
    public TaskDto createTask(CreateTaskRequest request) {
        // Benutzer anhand der ID aus dem Request suchen
        User benutzer = userRepository.findById(request.getBenutzerId())
                .orElseThrow(()-> new NotFoundException("Benutzer mit ID " + request.getBenutzerId() + " nicht gefunden"));
        // Anfrage → Entity umwandeln
        Task aufgabe = taskMapper.toEntity(request, benutzer);
        // In Datenbank speichern
        Task entity = taskRepository.save(aufgabe);
        // Gespeicherte Aufgabe → DTO umwandeln
        return taskMapper.toDto(entity);
    }

    // Eine Aufgabe anhand der ID abrufen
    @Override
    public TaskDto getTaskById(Long id) {
        Task aufgabe = taskRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Aufgabe mit ID " + id + " nicht gefunden"));

        return taskMapper.toDto(aufgabe);
    }

    // Alle Aufgaben zurückgeben
    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()   // Alle Aufgaben aus der Datenbank holen (List<Task>)
                .stream()                // Die Liste in einen Stream umwandeln (damit man sie "durchlaufen" kann)
                .map(taskMapper::toDto) // Jede Task-Entity in ein TaskDto umwandeln
                .collect(Collectors.toList()); // Alle umgewandelten TaskDto-Objekte in eine Liste einsammeln und zurückgeben
    }

    // Aufgabe aktualisieren (z.B. Titel, Beschreibung, Fälligkeit)
    @Override
    public TaskDto updateTask(Long id, UpdateTaskRequest request) {
        // Versuch, die bestehende Aufgabe mit der angegebenen ID zu finden
        Task aufgabe = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aufgabe mit ID " + id + " nicht gefunden"));

        // Aufgabe mit neuen Daten aktualisieren (Benutzer bleibt gleich!)
        taskMapper.updateEntityFromDto(request, aufgabe);

        // Die geänderte Aufgabe in der Datenbank speichern
        Task entity = taskRepository.save(aufgabe);

        // Die gespeicherte Entity in ein TaskDto umwandeln und zurückgeben
        return taskMapper.toDto(entity);
    }

    // Aufgabe löschen
    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)){
            throw new NotFoundException("Aufgabe mit ID " + id + " existiert nicht");
        }
        taskRepository.deleteById(id);
    }

    // Nur den Erledigt-Status einer Aufgabe ändern
    @Override
    public TaskDto updateStatus(Long id, boolean erledigt) {
        Task aufgabe = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aufgabe mit ID " + id + " nicht gefunden"));
        aufgabe.setErledigt(erledigt);
        Task entity = taskRepository.save(aufgabe);
        return taskMapper.toDto(entity);
    }
}
