package com.sikhimarg.taskmanagement.mapper;

import com.sikhimarg.taskmanagement.dto.CreateUserRequest;
import com.sikhimarg.taskmanagement.dto.UserDto;
import com.sikhimarg.taskmanagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Wandelt ein User-Entity in ein UserDto um
    // Entity → DTO (für Antwort an den Client)
    public UserDto toDto(User entity){
        return new UserDto(
                entity.getId(),
                entity.getVorname(),
                entity.getNachname(),
                entity.getEmail()
                // Kein Passwort im DTO!
        );
    }

    // DTO → Entity (beim Registrieren oder Speichern)
    public User toEntity(CreateUserRequest dto){
        User user = new User();
        user.setVorname(dto.getVorname());
        user.setNachname(dto.getNachname());
        user.setEmail(dto.getEmail());
        user.setPasswort(dto.getPasswort());  // Achtung: ggf. vorher hashen!
        return user;
    }

    // DTO → bestehende Entity aktualisieren (z.B. für PUT)
    public void updateEntityFromDto(CreateUserRequest dto, User entity){
        if (dto == null || entity == null){
            return;// Wenn eines der Objekte null ist, wird nichts gemacht
        }
        // Felder vom DTO ins bestehende Entity übertragen
        entity.setVorname(dto.getVorname());
        entity.setNachname(dto.getVorname());
        entity.setEmail(dto.getEmail());
        entity.setPasswort(dto.getPasswort());
    }

}



/*** 🔒 Passwort-Hashing
 Wenn du später Sicherheit einbaust, solltest du in
 toEntity(...) nicht direkt
 das Klartext-Passwort setzen, sondern: ***/
//user.setPasswort(passwordEncoder.encode(dto.getPasswort()));
