package com.sikhimarg.taskmanagement.dto;

public class UserDto {

    private Long id;
    private String vorname;
    private String nachname;
    private String email;
//    private String passwort;
    // Konstruktor

    public UserDto(Long id, String vorname, String nachname, String email) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
//        this.passwort = passwort;
    }

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

//    public String getPasswort() {
//        String getPasswort;
//    }
}

