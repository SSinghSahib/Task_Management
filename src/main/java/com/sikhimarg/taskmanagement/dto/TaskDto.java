package com.sikhimarg.taskmanagement.dto;

public class TaskDto {

    private Long id;
    private String titel;
    private String beschreibung;
    private boolean erledigt;
    private Long benutzerId;

    // Konstruktor
    public TaskDto(Long id, String titel, String beschreibung, boolean erledigt, Long benutzerId) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.erledigt = erledigt;
        this.benutzerId = benutzerId;
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
}
/***💡 Anmerkung: Nur Getter?
 Ja – da DTOs meist nur zum Lesen verwendet werden, reichen Getter.
 Wenn du in deiner Anwendung Setter brauchst
 (z.B. für automatische Befüllung oder Tests),
 kannst du sie natürlich ergänzen.
***/