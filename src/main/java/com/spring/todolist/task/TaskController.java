package com.spring.todolist.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> allTasks = this.taskService.getAll();
		return new ResponseEntity<>(allTasks, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getElementById(@PathVariable Long id) {
		Optional<Task> task = this.taskService.getById(id);
		
		if(task.isPresent()) {
			return new ResponseEntity<>(task.get(), HttpStatus.OK);
		} else {
			throw new Error("Element Not Found");
		}
 	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@Valid @RequestBody TaskCreateDTO data) {
		Task newTask = this.taskService.createTask(data);
		return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Task> deleteById(@PathVariable Long id) {
		boolean deleted = this.taskService.deleteById(id);
		
		if(deleted == true) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		
		throw new Error("Element Not Found");
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Task> updateById(@PathVariable Long id, @Valid @RequestBody TaskCreateDTO data) {
		Optional<Task> updated = this.taskService.updateById(id, data);
		
		if(updated.isPresent()) {
			return new ResponseEntity<Task>(updated.get(), HttpStatus.OK);
		}
		
		throw new Error("Element Not Found");
	}
	
	
	
}
