package com.training.micro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MyFirstTest4 {

    @Autowired
    private TestEntityManager tem;

    @Autowired
    private IPersonDao        ps;


    @Test
    public void test_person_rest() {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(100);
        this.tem.persist(personLoc);
        this.tem.flush();
        // this.ps.save(personLoc);
        Person findByNameLoc = this.ps.findByName("osman");
        Assertions.assertEquals(findByNameLoc,
                                personLoc);
    }

}
