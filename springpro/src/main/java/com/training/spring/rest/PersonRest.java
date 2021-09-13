package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.Person;
import com.training.spring.services.PersonService;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonRest {

    @Autowired
    private PersonService ps;

    @PostMapping("/add")
    public String person(@Validated @RequestBody final Person personParam) {
        System.out.println(personParam);
        this.ps.add(personParam);
        return "OK";
    }


}
