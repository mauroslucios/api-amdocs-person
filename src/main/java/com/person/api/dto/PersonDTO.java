package com.person.api.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.person.api.entities.Person;
import com.person.api.entities.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
	
	public PersonDTO(Person person) {
		this.id = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.cpf = person.getCpf();
		this.birthDate = person.getBirthDate();
		this.phones = person.getPhones();
	}

	private Long id;
	
	@NotEmpty
	@Size(min = 2, max =100)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2, max =100)
	private String lastName;
	
	@NotEmpty
	private String cpf;
	
	private LocalDate birthDate;
	
	@Valid
	@NotEmpty
	private List<Phone> phones;
	
	public static List<PersonDTO> converter(List<Person> persons){
		return persons.stream().map(PersonDTO::new).collect(Collectors.toList());
	}
}
