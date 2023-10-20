package com.spring.todolist.task;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
public class Task {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Getter
	@Setter
	private String content;
	
	@Column
	@Getter
	@Setter
	private Date createdAt;
	
	public Task() {}
	
	public Task(String content, Date createdAt) {
		this.content = content;
		this.createdAt = createdAt;
	}
}
