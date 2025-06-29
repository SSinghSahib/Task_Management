package com.sikhimarg.taskmanagement.controller;

import com.sikhimarg.taskmanagement.dto.CreateUserRequest;
import com.sikhimarg.taskmanagement.dto.UserDto;
import com.sikhimarg.taskmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController  // ➤ Markiert die Klasse als REST-Controller
@RequestMapping("/api/users")  // ➤ Basis-URL für alle User-Endpunkte
public class UserController {

    private final UserService userService;
    // Konstruktor-Injektion für den Service
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 📌 POST /api/users
    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody CreateUserRequest request) {
        UserDto createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }
    // 📌 GET /api/users
    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAllUsers();// ➤ Gibt alle Benutzer als DTOs zurück
    }

    // 📌 GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto dto = userService.findById(id);
        return ResponseEntity.ok(dto);
    }
    // 📌 PUT /api/users/{id}
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @Valid @RequestBody CreateUserRequest updatedData){
        UserDto updated = userService.updateUser(id, updatedData);
        return ResponseEntity.ok(updated);// ➤ 200 OK + aktualisierter Benutzer
    }
    // 📌 DELETE /api/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();// ➤ 204 No Content (erfolgreich gelöscht)
    }

}
