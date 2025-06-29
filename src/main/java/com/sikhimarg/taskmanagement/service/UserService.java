package com.sikhimarg.taskmanagement.service;

import com.sikhimarg.taskmanagement.dto.CreateUserRequest;
import com.sikhimarg.taskmanagement.dto.UserDto;
import com.sikhimarg.taskmanagement.entity.User;

import java.util.List;

public interface UserService {
    //1. 🎯 Benutzer erstellen (Registrierung)
    UserDto createUser(CreateUserRequest request);

    //2. 📌 Benutzer anhand der ID finden (z.B. für Task-Zuweisung)
    UserDto findById(Long id);

    // 🧾 Benutzer-DTO anhand der ID (z.B. für GET /users/{id})
//    UserDto getUserById(Long id);

    //3. 📃 Alle Benutzer auflisten (optional)
    List<UserDto> getAllUsers();

    //4. 🗑 Benutzer löschen (optional)
    void deleteUser(Long id);

    //5. ✏️ Benutzer aktualisieren (z.B. Namen ändern – optional)
    UserDto updateUser(Long id, CreateUserRequest updatedData);

    //6. 🔐 Benutzer per E-Mail und Passwort finden (z.B. Login)
    User findByEmail(String email);


    //Holt Benutzer-Entity anhand der ID (für interne Verwendung z.B. bei Aufgaben)
}
