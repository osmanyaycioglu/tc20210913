package com.training.spring.employeep;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeDao eo;

    public void add(final Employee em) {
        this.eo.save(em);
    }


    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public void update(final Employee em) {
        Employee findByIdLoc = this.eo.takeEmployee(em.getPersonId());
        System.out.println("-------------------");
        System.out.println(findByIdLoc);
        em.setVers(findByIdLoc.getVers());
        this.eo.save(em);
        System.out.println("Test db1");
        System.out.println("Test db2");
        System.out.println("Test db3");
        System.out.println("Test db4");
        System.out.println("Test db5");
    }

}
