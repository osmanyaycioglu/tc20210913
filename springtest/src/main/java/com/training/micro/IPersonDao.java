package com.training.micro;

import org.springframework.data.repository.CrudRepository;

public interface IPersonDao extends CrudRepository<Person, Long> {

    Person findByName(String name);
}
