package com.sikhimarg.taskmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;

public class CreateUserRequest {
    @NotBlank(message = "Vorname darf nicht leer sein")
    private String vorname;

    @NotBlank(message = "Nachname darf nicht leer sein")
    private String nachname;

    @NotBlank(message = "E-Mail darf nicht leer sein")
    @Email(message = "Ungültige E-Mail-Adresse")
    private String email;

    @NotBlank(message = "Passwort darf nicht leer sein")
    private String passwort;

    // Getter

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


    // Setter

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
