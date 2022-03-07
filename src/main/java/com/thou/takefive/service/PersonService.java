package com.thou.takefive.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thou.takefive.entity.Person;
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
		return this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Can't find that person"));
	}
	
	// UPDATE
	public Person updatePerson(Integer id, Person p) {
		
		// find person
		Person foundPerson = this.getById(id);
		
		// update info
		foundPerson.setName(p.getName());
		foundPerson.setEmail(p.getEmail());
		foundPerson.setAge(p.getAge());
		foundPerson.setCoinLevel(p.getCoinLevel());
		foundPerson.setHealthLevel(p.getHealthLevel());
		foundPerson.setHappyLevel(p.getHappyLevel());
		foundPerson.setSmartLevel(p.getSmartLevel());
		foundPerson.setCreativeLevel(p.getCreativeLevel());
		
		// save back to db
		return this.repo.save(foundPerson);
	}
	
	// DELETE
	public boolean deletePerson(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}

