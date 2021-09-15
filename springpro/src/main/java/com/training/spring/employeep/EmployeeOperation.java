package com.training.spring.employeep;

import org.springframework.stereotype.Service;

import com.training.spring.aop.ELogLevel;
import com.training.spring.aop.LogMe;

@Service
public class EmployeeOperation {

    @LogMe(ELogLevel.TRACE)
    public String greet(final Employee emp) {
        return "Hello " + emp.getName() + " " + emp.getSurname();
    }

}
