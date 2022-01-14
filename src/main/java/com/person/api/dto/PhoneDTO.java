package com.person.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.person.api.entities.Phone;
import com.person.api.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PhoneDTO {
	
	
	public PhoneDTO(Phone phone) {
		this.type = phone.getType();
		this.number = phone.getNumber();
	}
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	@NotEmpty
	@Size(min=13, max=14)
	private String number;
	
	public static List<PhoneDTO> converter(List<Phone> phones){
		return phones.stream().map(PhoneDTO::new).collect(Collectors.toList());
	}

}
