package com.sikhimarg.taskmanagement.mapper;

import com.sikhimarg.taskmanagement.dto.CreateTaskRequest;
import com.sikhimarg.taskmanagement.dto.TaskDto;
import com.sikhimarg.taskmanagement.entity.Task;
import com.sikhimarg.taskmanagement.entity.User;

public class TaskMapper {
 /**
 * Wandelt ein Task-Entity in ein TaskDto um
 * → Wird z.B. bei GET oder POST verwendet,
 * um die Aufgabe dem Client zurückzugeben */
    public static TaskDto toDto (Task entity){
        return new TaskDto(
          entity.getId(),
          entity.getTitle(),
          entity.getBeschreibung(),
          entity.isErledigt(),
          entity.getBenutzer().getId()  // Nur ID, nicht ganzes User-Objekt
        );
    }
    /** Wandelt ein CreateTaskRequest + User in ein Task-Entity um
     * → Wird z.B. verwendet, wenn ein Client
     * eine neue Aufgabe erstellt **/

    public static Task toEntity(CreateTaskRequest dto, User benutzer){
        Task aufgabe = new Task();
        aufgabe.setTitle(dto.getTitel());
        aufgabe.setBeschreibung(dto.getBeschreibung());
        aufgabe.setErledigt(false); // Neue Aufgabe = noch nicht erledigt
        aufgabe.setBenutzer(benutzer);
        return aufgabe;
    }
}
