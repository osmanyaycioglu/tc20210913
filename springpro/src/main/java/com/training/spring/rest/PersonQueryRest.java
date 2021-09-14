package com.training.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.model.Person;
import com.training.spring.services.PersonService;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryRest {

    @Autowired
    private PersonService ps;

    @PostMapping("/get/one")
    public Person getperson(@RequestParam("pid") final Long personId) {
        return this.ps.getOne(personId);
    }

    @PostMapping("/get/all")
    public List<Person> getAllPerson() {
        return this.ps.getAll();
    }

    @PostMapping("/get/by/name")
    public List<Person> getPersonByName(@RequestParam("name") final String name) {
        return this.ps.getByName(name);
    }


}
