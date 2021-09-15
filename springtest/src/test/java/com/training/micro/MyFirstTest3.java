package com.training.micro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyFirstTest3 {

    @InjectMocks
    PersonService personService;

    @Mock
    IPersonDao    perDao;

    @Test
    public void test_person_rest() {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(100);
        String addLoc = this.personService.add(personLoc);
        Assertions.assertEquals(addLoc,
                                "OK");
    }

}
