package com.training.micro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PersonRest.class)
@AutoConfigureMockMvc
class WebMvcTest1 {


    @Autowired
    MockMvc       mockMvc;

    @Autowired
    ObjectMapper  om;

    @MockBean
    PersonService ps;


    @Test
    void givenNormalPerson_expectSUCCESS() throws Exception {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(90);
        MvcResult andReturnLoc = this.mockMvc.perform(MockMvcRequestBuilders.post("/person/add")
                                                                            .contentType(MediaType.APPLICATION_JSON)
                                                                            .content(this.om.writeValueAsBytes(personLoc)))
                                             .andExpect(MockMvcResultMatchers.status()
                                                                             .isOk())
                                             .andReturn();
        String contentAsStringLoc = andReturnLoc.getResponse()
                                                .getContentAsString();

        Assertions.assertThat(contentAsStringLoc)
                  .isEqualTo("SUCCESS");
    }

    @Test
    void givenOverWeightedPerson_expectFAILURE() throws Exception {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(350);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/person/add")
                                                   .contentType(MediaType.APPLICATION_JSON)
                                                   .content(this.om.writeValueAsBytes(personLoc)))
                    .andExpect(MockMvcResultMatchers.status()
                                                    .isBadRequest());
    }

}
