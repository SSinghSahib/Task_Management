package com.sikhimarg.taskmanagement.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // explizit, da "user" in manchen DBs reserviert ist
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vorname;
    private String nachname;

    @Column(unique = true,nullable = false)
    private String email;
    // Passwort (wird verschlüsselt gespeichert – später mit Security)
    private String passwort;


 /*** // Konstruktoren ***
  * Java stellt automatisch einen parameterlosen Standard-Konstruktor zur Verfügung
  * JPA (Hibernate) benötigt genau diesen parameterlosen Konstruktor,
       um Entities aus der Datenbank zu erzeugen. ***/

    // Getter

    public Long getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }


    //Setter

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


    /*** Damit ergibt sich (vereinfacht):
     Ein User hat viele Tasks
     Ein Task gehört zu genau einem User ***/

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();
}
