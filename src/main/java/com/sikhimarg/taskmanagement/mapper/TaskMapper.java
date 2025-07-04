package com.sikhimarg.taskmanagement.mapper;

import com.sikhimarg.taskmanagement.dto.CreateTaskRequest;
import com.sikhimarg.taskmanagement.dto.TaskDto;
import com.sikhimarg.taskmanagement.dto.UpdateTaskRequest;
import com.sikhimarg.taskmanagement.entity.Task;
import com.sikhimarg.taskmanagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
 /**
 * Wandelt ein Task-Entity in ein TaskDto um
  Wird z.B. bei GET oder POST verwendet,
  um die Aufgabe dem Client zurückzugeben */
 // Entity → DTO (für Antwort an den Client)
    public TaskDto toDto(Task entity){
        return new TaskDto(
                entity.getId(),             // ID der Aufgabe
                entity.getTitle(),          //  Titel der Aufgabe
                entity.getBeschreibung(),    // Beschreibung
                entity.isErledigt(),          //  ob erledigt
                entity.getBenutzer().getId(), // Nur ID, nicht ganzes User-Objekt
                entity.getFaelligkeit()     // Fälligkeitsdatum übergeben
        );
    }

    /** Wandelt ein CreateTaskRequest + User in ein Task-Entity um
     Wird z.B. verwendet, wenn ein Client eine neue Aufgabe erstellt **/
    // DTO → Entity (beim Registrieren oder Speichern)
    public Task toEntity(CreateTaskRequest dto, User benutzer) {
        Task entity = new Task();
        entity.setTitle(dto.getTitel());                //Titel aus dem DTO übernehmen
        entity.setBeschreibung(dto.getBeschreibung());  //Beschreibung übernehmen
        entity.setFaelligkeit(dto.getFaelligkeit());   // Fälligkeitsdatum setzen(falls angegeben)
        entity.setErledigt(false);                      // Neue Aufgaben sind immer unerledigt
        entity.setBenutzer(benutzer);                   // Benutzer-Zuordnung
        return entity;
    }

    //DTO → bestehende Entity aktualisieren (z.B. für PUT)
    public void updateEntityFromDto(UpdateTaskRequest dto, Task entity){
        if (dto == null || entity == null){
            return; // Wenn eines der Objekte null ist, wird nichts gemacht
        }
        // Neue Werte ins bestehende Task-Entity übertragen
        entity.setTitle(dto.getTitel());
        entity.setBeschreibung(dto.getBeschreibung());
        entity.setErledigt(dto.isErledigt());    // Status aus DTO übernehmen
        entity.setFaelligkeit(dto.getFaelligkeit()); // Neues Fälligkeitsdatum
    }
}
