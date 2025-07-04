package com.sikhimarg.taskmanagement.repository;

import com.sikhimarg.taskmanagement.entity.Task;
import com.sikhimarg.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
