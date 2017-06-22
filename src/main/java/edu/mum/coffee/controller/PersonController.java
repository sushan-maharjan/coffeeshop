package edu.mum.coffee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/person")
	public List<Person> getAllPerson(){ return personService.findAll(); }

	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable long id){
		return personService.findById(id);
	}
	
	@PostMapping("/person")
	public void create(@RequestBody Person person){
		personService.savePerson(person);		
	}
	
	@PutMapping("/person")
	public void update (@RequestBody Person person){
		personService.savePerson(person);
	}
	
	@DeleteMapping("/person/{id}")
	public void delete(@PathVariable long id){
		personService.removePerson(personService.findById(id));
	}

	@GetMapping("person/byEmail/{email}")
	public Person getPersonByEmail(@PathVariable String email){
		return personService.findByEmail(email);
	}
	
	
}
