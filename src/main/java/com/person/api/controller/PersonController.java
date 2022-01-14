package com.person.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.api.repository.PersonRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="API REST People")
@CrossOrigin(origins="*")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
}
