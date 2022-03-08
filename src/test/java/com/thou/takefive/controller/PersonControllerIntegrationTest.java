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
import com.thou.takefive.entity.Person;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"}, 
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void createPersonTest() throws Exception {
		// Given
		Person newPerson = new Person("Adam", "thousand_leaves@hotmail.com", 33, 500, 50, 50, 50, 50);
		String newPersonJSON = this.mapper.writeValueAsString(newPerson);
		Person savedPerson = new Person(4, "Adam", "thousand_leaves@hotmail.com", 33, 500, 50, 50, 50, 50);
		String savedPersonJSON = this.mapper.writeValueAsString(savedPerson);
		// When
		RequestBuilder request = post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newPersonJSON);
		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(savedPersonJSON);
		// Then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}
	
	@Test
	void readAllPeopleTest() throws Exception {
		// Given
		List<Person> people = new ArrayList<>();
								// name, email, 				age, coinLevel, healthLevel, happyLevel, smartLevel, creativeLevel
		people.add(new Person(1, "Adam", "thousand_leaves@hotmail.com", 33, 500, 100, 50, 20, 50));
		people.add(new Person(2, "Alfie", "alfie@yahoo.com", 23, 500, 100, 50, 20, 50));
		people.add(new Person(3, "Alice", "alice@gmail.com", 30, 500, 100, 50, 20, 50));
		
		String savedPeopleJSON = this.mapper.writeValueAsString(people);
		// When
		RequestBuilder req = get("/readAll");
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedPeopleJSON);
		// Then
		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);		
	}
	
	@Test
	void readByIdTest() throws Exception {
		// Given
		// name, email, 				age, coinLevel, healthLevel, happyLevel, smartLevel, creativeLevel
		Person person = new Person(1, "Adam", "thousand_leaves@hotmail.com", 33, 500, 100, 50, 20, 50);
		String savedPersonJSON = this.mapper.writeValueAsString(person);
		
		// When
		RequestBuilder reqId = get("/readById/1");
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedPersonJSON);
		
		// Then
		this.mvc.perform(reqId).andExpect(responseStatus).andExpect(responseContent);
	}
	
	@Test
	void updatePersonTest() throws Exception {
		// Given
		Person updatedPerson = new Person(1, "Alfie", "alfie@yahoo.com", 33, 500, 100, 50, 20, 50);
		String updatedPersonJSON = this.mapper.writeValueAsString(updatedPerson);
		// When
		RequestBuilder requestUpdate = put("/updatePerson/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(updatedPersonJSON);
		ResultMatcher responseStatus = status().isAccepted();
		ResultMatcher reponseContent = content().json(updatedPersonJSON);
		// Then
		this.mvc.perform(requestUpdate).andExpect(responseStatus).andExpect(reponseContent);
	}
	
	@Test
	void deletePersonTest() throws Exception {
		this.mvc.perform(delete("/delete/1")).andExpect(status().isAccepted());
	}

}
