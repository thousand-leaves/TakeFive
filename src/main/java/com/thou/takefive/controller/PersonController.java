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

import com.thou.takefive.entity.Person;
import com.thou.takefive.service.PersonService;

@RestController
public class PersonController {

	private PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(this.service.createPerson(person), HttpStatus.CREATED);
	}
	
	// READ ALL
	@GetMapping("/readAll")
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity<List<Person>>(this.service.getAllPersons(), HttpStatus.OK);
	}
	
	// READ BY ID
	@GetMapping("/readById/{id}")
	public ResponseEntity<Person> getById(@PathVariable Integer id) {
		return new ResponseEntity<Person>(this.service.getById(id), HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/updatePerson/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person) {
        return new ResponseEntity<Person>(this.service.updatePerson(id, person), HttpStatus.ACCEPTED);
    }
	
    // DELETE BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        boolean hasDeleted = this.service.deletePerson(id);
        
        if (hasDeleted) {
        	return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.ACCEPTED);
        } else {
        	return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.NOT_FOUND);
        }
    	
    }
	
	
}