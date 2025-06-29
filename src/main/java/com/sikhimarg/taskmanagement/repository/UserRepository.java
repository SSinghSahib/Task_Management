package com.sikhimarg.taskmanagement.repository;

import com.sikhimarg.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Optional: zusätzliche Methoden
    boolean existByEmail(String email);
    Optional<User> findByEmail(String email);
}
