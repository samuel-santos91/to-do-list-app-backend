package com.spring.todolist.task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getAll() {
		return this.taskRepository.findAll();
	}
	
	public Optional<Task> getById(Long id) {
		Optional<Task> foundTask = taskRepository.findById(id);
		return foundTask;
	}
	
	public Task createTask(TaskCreateDTO data) {
		String content = data.getContent().trim();
		Date createdAt = new Date();
		
		Task newTask = new Task(content, createdAt);
		
		Task created = this.taskRepository.save(newTask);
		
		return created;
	}
	
	public boolean deleteById(Long id) {
		Optional<Task> foundTask = this.getById(id);
		
		if(foundTask.isPresent()) {
			this.taskRepository.delete(foundTask.get());
			return true;
		}
		
		return false;
	}
	
	public Optional<Task> updateById(Long id, TaskCreateDTO data) {
		Optional<Task> foundTask = this.getById(id);
		
		if(foundTask.isPresent()) {
			Task toUpdate = foundTask.get();
			
			if(data.getContent() != null) {
				toUpdate.setContent(data.getContent());
			}
			
			Task updatedTask = this.taskRepository.save(toUpdate);
			
			return Optional.of(updatedTask);
		}
		
		return foundTask;
	}
	
	
}
