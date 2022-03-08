package com.thou.takefive.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.thou.takefive.entity.Person;
import com.thou.takefive.repo.PersonRepo;

@SpringBootTest
public class PersonServiceUnitTest {

		@Autowired
		private PersonService service;
		
		@MockBean
		private 	PersonRepo repo;
		
		// Create Person Test
		@Test
		void testCreate() {
			// Given
			Person toSave = new Person(1, "Barry", "barry@hotmail.com", 30, 10, 25, 50, 75, 100);
			Person saved = new Person(1, "Barry", "barry@hotmail.com", 30, 10, 25, 50, 75, 100);
			// When
			Mockito.when(this.repo.save(toSave)).thenReturn(saved);
			// Then
			Assertions.assertThat(this.service.createPerson(toSave)).isEqualTo(saved);
			// Verify
			Mockito.verify(this.repo, Mockito.times(1)).save(toSave);
		}
		
		// Read Person by ID Test
		@Test
		void testReadById() {
			// Given
			int id = 1;
			Person expected = new Person(1, "Barry", "barry@hotmail.com", 30, 10, 25, 50, 75, 100);
			// When
			Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));
			// Then
			Assertions.assertThat(this.service.getById(id)).isEqualTo(expected);
			// Verify
			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		}
		
		// Read All Persons Test
		@Test
		void testReadAll() {
			// Given
			int id = 1;
			Person testPerson = new Person(1, "Barry", "barry@hotmail.com", 30, 10, 25, 50, 75, 100);
			testPerson.setId(id);
			List<Person> people = List.of(testPerson);
			// When
			Mockito.when(this.repo.findAll()).thenReturn(people);
			// Then
			Assertions.assertThat(this.service.getAllPersons()).isEqualTo(people);
			// Verify
			Mockito.verify(this.repo, Mockito.times(1)).findAll();
		}
		
		// Update Person Test
		@Test
		void testUpdate() {
			
			// Given
			int id = 1;
			Person savedPerson = new Person(1, "Ian", "ian@outlook.com", 100, 5, 20, 40, 200, 500);
			Person preUpdate = new Person("Ian", "ian@outlook.com", 100, 5, 20, 40, 200, 500);
			Person postUpdate = new Person(1, "George", "ian@outlook.com", 100, 5, 20, 40, 200, 500);
			// When
			Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(savedPerson));
			Mockito.when(this.repo.save(postUpdate)).thenReturn(postUpdate);
			// Then
			Assertions.assertThat(this.service.updatePerson(id, preUpdate)).isEqualTo(postUpdate);
			//Verify
			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Person.class));
					
		}
		
		// Delete Person by ID Test
		@Test
		void testDelete() {
			// Given
			int id = 1;
			// When
			Mockito.when(this.repo.existsById(id)).thenReturn(false);
			// Then
			Assertions.assertThat(this.service.deletePerson(id)).isTrue();
			// Verify
			Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
			Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
		}
		
}

















