package com.sikhimarg.taskmanagement.service;

import com.sikhimarg.taskmanagement.dto.CreateUserRequest;
import com.sikhimarg.taskmanagement.dto.UserDto;
import com.sikhimarg.taskmanagement.entity.User;

import java.util.List;

public interface UserService {
    // Benutzer erstellen (Registrierung)
    UserDto createUser(CreateUserRequest request);

    // Benutzer anhand der ID finden (z.B. für Task-Zuweisung)
    UserDto findById(Long id);

    // Benutzer-DTO anhand der ID (z.B. für GET /users/{id})
//    UserDto getUserById(Long id);

    // Alle Benutzer auflisten (optional)
    List<UserDto> getAllUsers();

    // Benutzer löschen (optional)
    void deleteUser(Long id);

    // Benutzer aktualisieren (z.B. Namen ändern – optional)
    UserDto updateUser(Long id, CreateUserRequest updatedData);

    // Benutzer per E-Mail und Passwort finden (z.B. Login)
    User findByEmail(String email);

}
