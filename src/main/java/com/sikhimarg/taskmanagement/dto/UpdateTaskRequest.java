package com.sikhimarg.taskmanagement.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UpdateTaskRequest {

    @NotBlank(message = "Titel darf nicht leer sein")
    private String titel;
    private String beschreibung;
    private LocalDate faelligkeit;
    private boolean erledigt; //Beim Bearbeiten darf der Status gesetzt werden

    // Getter

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public LocalDate getFaelligkeit() {
        return faelligkeit;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    // Setter

    public void setTitle(String titel) {
        this.titel = titel;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setFaelligkeit(LocalDate faelligkeit) {
        this.faelligkeit = faelligkeit;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }
}
