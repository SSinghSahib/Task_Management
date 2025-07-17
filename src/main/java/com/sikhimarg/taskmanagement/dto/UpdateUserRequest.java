package com.sikhimarg.taskmanagement.dto;

public class UpdateUserRequest {
    private String vorname;
    private String nachname;
    private String email;
    private String passwort;

    public String getPasswort() {
        return passwort;
    }

    public String getEmail() {
        return email;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }


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
}
