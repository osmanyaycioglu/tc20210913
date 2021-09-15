package com.training.spring.employeep;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.aop.ELogLevel;
import com.training.spring.aop.LogMe;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeRest {

    @Autowired
    private EmployeeService   es;

    @Autowired
    private EmployeeOperation eo;


    @PostMapping("/greet")
    @LogMe(ELogLevel.DEBUG)
    public String greet(@Valid @RequestBody final Employee em) {
        return this.eo.greet(em);
    }

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
