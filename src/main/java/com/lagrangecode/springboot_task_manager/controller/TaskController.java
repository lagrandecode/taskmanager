package com.lagrangecode.springboot_task_manager.controller;


import com.lagrangecode.springboot_task_manager.model.Task;
import com.lagrangecode.springboot_task_manager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(@RequestParam(required = false) Boolean completed){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }
}
