package com.person.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.person.api.dto.PersonDTO;
import com.person.api.entities.Person;
import com.person.api.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

	private PersonRepository personRepository;
	
//	@Autowired
//	public PersonService(PersonRepository personRepository) {
//		this.personRepository = personRepository;
//	}

	public List<PersonDTO> listPerson() {
		List<Person> persons = personRepository.findAll();
		return  PersonDTO.converter(persons);
	}

	public Person createPerson(Person person) {
		return personRepository.save(person);
		
	}

	public Person findPerson(Long id) {
		return personRepository.findById(id).get();
	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
