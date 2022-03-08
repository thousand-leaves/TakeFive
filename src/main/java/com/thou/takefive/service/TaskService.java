package com.thou.takefive.service;

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

}
