package com.thou.takefive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thou.takefive.entity.Task;
import com.thou.takefive.service.TaskService;

@RestController
public class TaskController {
	
	private TaskService service;
	
	@Autowired
	public TaskController(TaskService service) {
		this.service = service;
	}
		
		// CREATE
		@PostMapping("/createTask")
		public ResponseEntity<Task> createTask(@RequestBody Task task) {
			return new ResponseEntity<Task>(this.service.createTask(task), HttpStatus.CREATED);
		}

}
