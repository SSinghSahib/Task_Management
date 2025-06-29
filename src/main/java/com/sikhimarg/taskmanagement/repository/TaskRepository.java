package com.sikhimarg.taskmanagement.repository;

import com.sikhimarg.taskmanagement.entity.Task;
import com.sikhimarg.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Alle Aufgaben eines bestimmten Benutzers
    List<Task> findByUser(User user);

    // Optional: Aufgaben nach "done"-Status
    List<Task> findByUserAndDone(User user, boolean done);
}
