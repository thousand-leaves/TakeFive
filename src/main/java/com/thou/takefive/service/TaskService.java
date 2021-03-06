package com.thou.takefive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thou.takefive.entity.Task;
import com.thou.takefive.exceptions.TaskNotFoundException;
import com.thou.takefive.repo.TaskRepo;

@Service
public class TaskService {

	private TaskRepo repo;
	
	@Autowired
	public TaskService(TaskRepo repo) {
		this.repo = repo;
	}
	
	// CREATE A TASK
	public Task createTask(Task t) {
		return this.repo.save(t);
	}

	// READ ALL TASKS
	public List<Task> getAllTasks() {
		return this.repo.findAll();
	}
	
	// READ TASK BY ID
	public Task getById(Integer taskId) {
		return this.repo.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Can't find that task"));
	}
	
	// UPDATE TASK BY ID
	public Task updateTask(Integer taskId, Task t) {
		
		// find task
		Task foundTask = this.getById(taskId);
		
		// update info
		foundTask.setCategory(t.getCategory());
		foundTask.setDescription(t.getDescription());
		foundTask.setCoinReward(t.getCoinReward());
		foundTask.setHealthReward(t.getHealthReward());
		foundTask.setHappyReward(t.getHappyReward());
		foundTask.setSmartReward(t.getSmartReward());
		foundTask.setCreativeReward(t.getCreativeReward());
		
		// save back to db
		return this.repo.save(foundTask);
	}
	
	// DELETE TASK BY ID
	public boolean deleteTask(Integer id) throws TaskNotFoundException {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	// RETURN RANDOM TASK
	public Task doRandomTask() {
		return this.repo.doRandomTask();
	}
	
}
