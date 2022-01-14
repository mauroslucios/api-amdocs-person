package com.person.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.api.entities.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
