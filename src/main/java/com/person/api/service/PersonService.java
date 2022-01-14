package com.person.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.api.dto.PersonDTO;
import com.person.api.entities.Person;
import com.person.api.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<PersonDTO> listPerson() {
		List<Person> persons = personRepository.findAll();
		return PersonDTO.converter(persons);
	}

	public Person insertPerson(Person person) {
		return personRepository.save(person);
	}
}
