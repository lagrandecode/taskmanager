package com.lagrangecode.springboot_task_manager.controller;


import com.lagrangecode.springboot_task_manager.model.Task;
import com.lagrangecode.springboot_task_manager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(@RequestParam(required = false) Boolean completed){
        List<Task> tasks;
        if(completed == null){
            tasks = taskService.getAllTask().stream().filter(task -> task.getCompleted().equals(completed)).toList();

        } else {
            tasks = taskService.getAllTask();
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Task task1 = taskService.getTaskById(id);
        task1.setCompleted(task.getCompleted());
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        return new ResponseEntity<>(taskService.saveTask(task1), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        try{
            taskService.deleteTaskById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
