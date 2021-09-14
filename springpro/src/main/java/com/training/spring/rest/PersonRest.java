package com.training.spring.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.model.Person;
import com.training.spring.model.Phone;
import com.training.spring.services.PersonService;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonRest {

    @Autowired
    private PersonService ps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person personParam) {
        System.out.println(personParam);
        personParam.getAddress()
                   .setPerson(personParam);
        Set<Phone> phonesLoc = personParam.getPhones();
        for (Phone phoneLoc : phonesLoc) {
            phoneLoc.setPerson(personParam);
        }
        this.ps.add(personParam);
        return "OK";
    }

    @PostMapping("/update")
    public String update(@Validated @RequestBody final Person personParam) {
        System.out.println(personParam);
        personParam.getAddress()
                   .setPerson(personParam);
        Set<Phone> phonesLoc = personParam.getPhones();
        for (Phone phoneLoc : phonesLoc) {
            phoneLoc.setPerson(personParam);
        }
        this.ps.update(personParam);
        return "OK";
    }


}
