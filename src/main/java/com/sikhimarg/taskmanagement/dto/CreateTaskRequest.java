package com.sikhimarg.taskmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTaskRequest {
    // Titel der Aufgabe – Pflichtfeld
    @NotBlank(message = "Titel darf nicht leer sein")
    private String titel;

    // Beschreibung der Aufgabe – optional
    private String beschreibung;

    // ID des Benutzers, dem die Aufgabe gehört – Pflichtfeld
    @NotNull(message = "Benutzer-ID darf nicht null sein")
    private Long benutzerId;


    // Getter

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Long getBenutzerId() {
        return benutzerId;
    }


    // Setter

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setBenutzerId(Long benutzerId) {
        this.benutzerId = benutzerId;
    }
}
