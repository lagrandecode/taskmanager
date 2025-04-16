package com.lagrangecode.springboot_task_manager.repository;


import com.lagrangecode.springboot_task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
