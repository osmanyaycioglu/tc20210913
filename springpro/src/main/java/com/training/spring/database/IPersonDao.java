package com.training.spring.database;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

}
