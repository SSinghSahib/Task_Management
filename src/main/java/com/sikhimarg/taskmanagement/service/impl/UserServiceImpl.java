package com.sikhimarg.taskmanagement.service.impl;

import com.sikhimarg.taskmanagement.dto.CreateUserRequest;
import com.sikhimarg.taskmanagement.dto.UserDto;
import com.sikhimarg.taskmanagement.entity.User;
import com.sikhimarg.taskmanagement.exception.NotFoundException;
import com.sikhimarg.taskmanagement.mapper.UserMapper;
import com.sikhimarg.taskmanagement.repository.UserRepository;
import com.sikhimarg.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository benutzerRepository, UserMapper userMapper) {
        this.userRepository = benutzerRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(CreateUserRequest dto){
        User entity = userMapper.toEntity(dto);
        User gespeichert = userRepository.save(entity);
        return userMapper.toDto(gespeichert);
    }

    @Override
    public UserDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Benutzer nicht gefunden"));
        return userMapper.toDto(entity);  // Nur DTO geht zurück an den Client
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userListe = userRepository.findAll();
        List<UserDto> userDtoListe = new ArrayList<>();
        for (User user : userListe){
            UserDto dto = userMapper.toDto(user);
            userDtoListe.add(dto);
        }
        return userDtoListe;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Benutzer mit ID " + id + " nicht gefunden"));
            userRepository.delete(user);
    }

    @Override
    public UserDto updateUser(Long id, CreateUserRequest updatedData) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Benutzer mit ID " + id + " nicht gefunden"));

        userMapper.updateEntityFromDto(updatedData, user);

        User updated = userRepository.save(user);
        return userMapper.toDto(updated);
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Benutzer mit E-Mail " + email + " nicht gefunden"));
        return userMapper.toDto(user);
    }


    /**
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("E-Mail ist  ungültig"));
    }  **/


}
