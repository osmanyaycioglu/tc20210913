package com.training.micro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(PersonRest.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class MyFirstTest2 {

    @Autowired
    MockMvc       mockMvc;

    @MockBean
    PersonService personService;

    @MockBean
    IPersonDao    personDao;

    @Test
    public void test_person_rest() throws Exception {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(100);
        ObjectMapper mapperLoc = new ObjectMapper();
        MvcResult andReturnLoc = this.mockMvc.perform(MockMvcRequestBuilders.post("/person/add")
                                                                            .contentType(MediaType.APPLICATION_JSON)
                                                                            .content(mapperLoc.writeValueAsString(personLoc)))
                                             .andExpect(MockMvcResultMatchers.status()
                                                                             .isOk())
                                             .andReturn();

        String addLoc = andReturnLoc.getResponse()
                                    .getContentAsString();
        Assertions.assertEquals(addLoc,
                                "SUCCESS");
    }

}
