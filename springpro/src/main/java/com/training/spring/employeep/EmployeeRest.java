package com.training.spring.employeep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeRest {

    @Autowired
    private EmployeeService es;

    @PostMapping("/add")
    public String add(@RequestBody final Employee em) {
        this.es.add(em);
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Employee em) {
        this.es.update(em);
        return "OK";
    }


}
