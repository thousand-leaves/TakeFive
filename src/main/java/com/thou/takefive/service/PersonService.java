package com.thou.takefive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thou.takefive.entity.Person;
import com.thou.takefive.exceptions.PersonNotFoundException;
import com.thou.takefive.repo.PersonRepo;

@Service
public class PersonService {
	
	private PersonRepo repo;
	
	@Autowired
	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}
	
	// CREATE
	public Person createPerson(Person p) {
		return this.repo.save(p);
	}
	
	// READ ALL
	public List<Person> getAllPersons() {
		return this.repo.findAll();
	}
	
	// READ BY ID
	public Person getById(Integer id) {
		return this.repo.findById(id).orElseThrow(() -> new PersonNotFoundException("Can't find that person"));
	}
	
	// UPDATE
	public Person updatePerson(Integer id, Person newValues) {
		
		// find person
		Person foundPerson = this.getById(id);
		
		// update info
		foundPerson.setName(newValues.getName());
		foundPerson.setEmail(newValues.getEmail());
		foundPerson.setAge(newValues.getAge());
		foundPerson.setCoinLevel(newValues.getCoinLevel());
		foundPerson.setHealthLevel(newValues.getHealthLevel());
		foundPerson.setHappyLevel(newValues.getHappyLevel());
		foundPerson.setSmartLevel(newValues.getSmartLevel());
		foundPerson.setCreativeLevel(newValues.getCreativeLevel());
		
		// save back to db
		return this.repo.save(foundPerson);
	}
	
	// DELETE
	public boolean deletePerson(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}

