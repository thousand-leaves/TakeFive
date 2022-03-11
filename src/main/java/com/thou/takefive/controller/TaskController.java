 package com.thou.takefive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		// CREATE TASK
		@PostMapping("/createTask")
		public ResponseEntity<Task> createTask(@RequestBody Task task) {
			return new ResponseEntity<Task>(this.service.createTask(task), HttpStatus.CREATED);
		}

		// READ ALL TASKS
		@GetMapping("/readAllTasks")
		public ResponseEntity<List<Task>> getAll() {
			return new ResponseEntity<List<Task>>(this.service.getAllTasks(), HttpStatus.OK);
		}
		
		// READ TASK BY ID
		@GetMapping("/readByTaskId/{taskId}")
		public ResponseEntity<Task> getByIndex(@PathVariable Integer taskId) {
			return new ResponseEntity<Task>(this.service.getById(taskId), HttpStatus.OK);
		}
		
		// UPDATE TASK
		@PutMapping("/updateTask/{taskId}")
	    public ResponseEntity<Task> updateTask(@PathVariable Integer taskId, @RequestBody Task task) {
	        return new ResponseEntity<Task>(this.service.updateTask(taskId, task), HttpStatus.ACCEPTED);
	    }
		
	    // DELETE TASK BY ID
	    @DeleteMapping("/deleteTask/{taskId}")
	    public ResponseEntity<Boolean> deleteByIndex(@PathVariable Integer taskId) {
	        boolean hasDeleted = this.service.deleteTask(taskId);
	        
	        if (hasDeleted) {
	        	return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.ACCEPTED);
	        } else {
	        	return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.NOT_FOUND);
	        }
	    }  
	    
	    // DO RANDOM TASK
	    @GetMapping("/doRandomTask")
	    public ResponseEntity<Task> doRandomTask() {
	    	return new ResponseEntity<Task>(this.service.doRandomTask(), HttpStatus.OK);
	    }
}
