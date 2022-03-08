package com.thou.takefive.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thou.takefive.entity.Task;
import com.thou.takefive.repo.TaskRepo;

@Service
public class TaskService {

	private TaskRepo repo;
	
	@Autowired
	public TaskService(TaskRepo repo) {
		this.repo = repo;
	}
	
	// CREATE
	public Task createTask(Task t) {
		return this.repo.save(t);
	}

	// READ ALL
	public List<Task> getAllTasks() {
		return this.repo.findAll();
	}
	
	// READ BY ID
	public Task getById(Integer taskId) {
		return this.repo.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Can't find that task"));
	}
}
