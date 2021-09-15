package com.training.micro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class MyFirstTest {

    @Autowired
    private PersonRest personRest;


    @Test
    public void test_person_rest() {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(100);
        String addLoc = this.personRest.add(personLoc);
        Assertions.assertEquals(addLoc,
                                "SUCCESS");
    }

}
