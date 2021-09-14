package com.training.spring.employeep;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeDao eo;

    public void add(final Employee em) {
        this.eo.save(em);
    }

    @Transactional
    // @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    public void update(final Employee em) {
        Optional<Employee> findByIdLoc = this.eo.findById(em.getPersonId());
        System.out.println("-------------------");
        System.out.println(findByIdLoc.orElse(null));
        this.eo.save(em);
    }

}
