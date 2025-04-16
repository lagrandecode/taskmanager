package com.lagrangecode.springboot_task_manager.service;


import com.lagrangecode.springboot_task_manager.model.Task;
import com.lagrangecode.springboot_task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(null);
    }
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }
    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
    public Task updateTask(Task task, Long id){
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setCompleted(task.getCompleted());
        return taskRepository.save(taskToUpdate);
    }

}
