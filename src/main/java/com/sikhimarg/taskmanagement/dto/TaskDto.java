package com.sikhimarg.taskmanagement.dto;

import java.time.LocalDate;

public class TaskDto {

    private Long id;
    private String titel;
    private String beschreibung;
    private boolean erledigt;
    private Long benutzerId;
    private LocalDate faelligkeit;

    // Konstruktor
    public TaskDto(){}

    public TaskDto(Long id, String titel, String beschreibung, boolean erledigt, Long benutzerId, LocalDate faelligkeit) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.erledigt = erledigt;
        this.benutzerId = benutzerId;
        this.faelligkeit = faelligkeit;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public Long getBenutzerId() {
        return benutzerId;
    }

    public LocalDate getFaelligkeit() {
        return faelligkeit;
    }

}


