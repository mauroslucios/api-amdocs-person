package com.person.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.person.api.dto.PersonDTO;
import com.person.api.entities.Person;
import com.person.api.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="API REST People")
@CrossOrigin(origins="*")
public class PersonController {

	
	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/persons")
	@ApiOperation(value="Return a list of people")
	public List<PersonDTO> listPerson(){
		return personService.listPerson();
	}
	
	@GetMapping("/persons/{id}")
	@ApiOperation(value="Find person for id")
	public Person findPerson(@PathVariable(value="id") Long id) {
		return personService.findPerson(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/persons")
    @ApiOperation(value="Create a person")
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	
		
}
