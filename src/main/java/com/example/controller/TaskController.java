package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task;
import com.example.TaskJpa;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskJpa taskJpa;
    
    // CREATE (USER)
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskJpa.save(task);
        return ResponseEntity.ok(savedTask);
    }
    
    // READ by name (USER)
    @GetMapping("/{name}")
    public ResponseEntity<Optional<Task>> getTaskByName(@PathVariable String name) {
        Optional<Task> task = taskJpa.findByTaskName(name);
        return ResponseEntity.ok(task);
    }
    
    // READ all (USER)    
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskJpa.findAll());
    }

    // UPDATE (ADMIN)
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskJpa.findById(id)
            .map(task -> {
                task.setTaskName(updatedTask.getTaskName());
                task.setDescription(updatedTask.getDescription());
                return ResponseEntity.ok(taskJpa.save(task));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE (ADMIN)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskJpa.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}

