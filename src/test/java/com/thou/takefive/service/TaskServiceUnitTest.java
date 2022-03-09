package com.thou.takefive.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.thou.takefive.entity.Task;
import com.thou.takefive.repo.TaskRepo;

@SpringBootTest
public class TaskServiceUnitTest {

	@Autowired
	private TaskService service;
	
	@MockBean
	private TaskRepo repo;
	
	// Create Task Test
	@Test
	void testCreate() {
		// Given
		Task toSave = new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50);
		Task saved = new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50);
		// When
		Mockito.when(this.repo.save(toSave)).thenReturn(saved);
		// Then
		Assertions.assertThat(this.service.createTask(toSave)).isEqualTo(saved);
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).save(toSave);
	}
	
	// Read Task by ID Test
	@Test
	void testReadById() {
		// Given
		int id = 1;
		Task expected = new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50);
		// When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));
		// Then
		Assertions.assertThat(this.service.getById(id)).isEqualTo(expected);
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	// Read All Tasks Test
	@Test
	void testReadAll() {
		// Given
		int id = 1;
		Task testTask = new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50);
		testTask.setTaskId(id);
		List<Task> tasks = List.of(testTask);
		// When
		Mockito.when(this.repo.findAll()).thenReturn(tasks);
		// Then
		Assertions.assertThat(this.service.getAllTasks()).isEqualTo(tasks);
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	// Update Task Test
	@Test
	void testUpdate() {
		
		// Given
		int id = 1;
		Task savedTask = new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50);
		Task preUpdate = new Task("creative", "Do this task", 10, 20, 30, 40, 50);
		Task postUpdate = new Task(1, "clever", "Do this task", 10, 20, 30, 40, 50);
		// When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(savedTask));
		Mockito.when(this.repo.save(Mockito.any(Task.class))).thenReturn(postUpdate);
		// Then
		Assertions.assertThat(this.service.updateTask(id, preUpdate)).isEqualTo(postUpdate);
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Task.class));		
	}
	
	// Delete Task Test
	@Test
	void testDelete() {
		// Given
		int id = 1;
		// When
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		// Then
		Assertions.assertThat(this.service.deleteTask(id)).isTrue();
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
	}
}
