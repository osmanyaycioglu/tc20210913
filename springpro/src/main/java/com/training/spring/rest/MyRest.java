package com.training.spring.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.Person;

@RestController
//@Controller
//@Repository
//@Configuration
//@Service
@RequestMapping("/rest")
public class MyRest {

    @GetMapping("/hello")
    public String hello(@RequestParam("isim") final String name) {
        return "Hello " + name;
    }


    @PostMapping("/add/person")
    public String person(@Validated @RequestBody final Person personParam) {
        System.out.println(personParam);
        return "OK";
    }

}
