package com.thou.takefive.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thou.takefive.entity.Task;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:task-schema.sql", "classpath:task-data.sql"}, 
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class TaskControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	// Create Task Test
	@Test
	void createTaskTest() throws Exception {
		// Given
		Task newTask = new Task("creative", "Do this task", 10, 20, 30, 40, 50);
		String newTaskJSON = this.mapper.writeValueAsString(newTask);
		Task savedTask = new Task(4, "creative", "Do this task", 10, 20, 30, 40, 50);
		String savedTaskJSON = this.mapper.writeValueAsString(savedTask);
		// When
		RequestBuilder request = post("/createTask")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newTaskJSON);
		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(savedTaskJSON);
		// Then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}
	
	// Read all tasks test
	@Test
	void readAllTasksTest() throws Exception {
		// Given
		List<Task> task = new ArrayList<>();
				  		//id, cat,  description,   coin health happy smart creative	
		task.add(new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50));
		task.add(new Task(2, "happy", "Do this task", 10, 20, 30, 40, 50));
		task.add(new Task(3, "health", "Do this task", 10, 20, 30, 40, 50));
		
		String savedTaskJSON = this.mapper.writeValueAsString(task);
		// When
		RequestBuilder req = get("/readAllTasks");
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedTaskJSON);
		// Then
		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);		
	}
	
	@Test
	void readByIdTest() throws Exception {
		// Given
								//id, cat,  description,   coin health happy smart creative	
		Task task = new Task(1, "creative", "Do this task", 10, 20, 30, 40, 50);
		String savedTaskJSON = this.mapper.writeValueAsString(task);
		
		// When
		RequestBuilder reqId = get("/readByTaskId/1");
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedTaskJSON);
		
		// Then
		this.mvc.perform(reqId).andExpect(responseStatus).andExpect(responseContent);
	}
	
	@Test
	void updateTaskTest() throws Exception {
		// Given
		Task updatedTask = new Task(1, "smart", "Do this thing", 10, 20, 30, 40, 50);
		String updatedTaskJSON = this.mapper.writeValueAsString(updatedTask);
		// When
		RequestBuilder requestUpdate = put("/updateTask/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(updatedTaskJSON);
		ResultMatcher responseStatus = status().isAccepted();
		ResultMatcher reponseContent = content().json(updatedTaskJSON);
		// Then
		this.mvc.perform(requestUpdate).andExpect(responseStatus).andExpect(reponseContent);
	}
	
	// Delete Task Test
	@Test
	void deleteTaskTest() throws Exception {
		this.mvc.perform(delete("/deleteTask/1"))
		.andExpect(status().isAccepted());
	}
	
}







