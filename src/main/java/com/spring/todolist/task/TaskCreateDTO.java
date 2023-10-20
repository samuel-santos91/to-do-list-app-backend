package com.spring.todolist.task;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class TaskCreateDTO {

	@Getter
	@Setter
	@Pattern(regexp = "^(?=\\S).+$", message="Content cannot be empty")
	private String content;
	
	public TaskCreateDTO() {};
	
	public TaskCreateDTO(String content) {
		this.content = content;
	}
}
