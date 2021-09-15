package com.training.micro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonRest {

    @Autowired
    private PersonService ps;

    @PostMapping("/add")
    public String add(@Valid @RequestBody final Person person) {
        this.ps.add(person);
        return "SUCCESS";
    }

}
