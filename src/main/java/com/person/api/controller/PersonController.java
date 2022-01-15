package com.person.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.person.api.dto.PersonDTO;
import com.person.api.entities.Person;
import com.person.api.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="API REST People")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class PersonController {

	
	private PersonService personService;
	
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
	
	@DeleteMapping("/persons/{id}")
	@ApiOperation(value="Delete person for id")
	public void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}
	
	@PutMapping("/persons")
	@ApiOperation(value="Update person complete")
	public Person updatePerson(@RequestBody Person person) {
		return  personService.updatePerson(person);
	}
	
	
	
	
}
