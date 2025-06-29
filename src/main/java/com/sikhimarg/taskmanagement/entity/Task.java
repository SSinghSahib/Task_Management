package com.sikhimarg.taskmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String beschreibung;    //description
    private boolean erledigt = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User benutzer;

    // ✅ Das hier muss vorhanden sein:✅ Wichtige Getter/Setter
    public User getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(User benutzer) {
        this.benutzer = benutzer;
    }

    // Kein Konstruktoren

    // Getter

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public User getUser() {
        return benutzer;
    }

    // Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    public void setUser(User user) {
        this.benutzer = user;
    }
}
