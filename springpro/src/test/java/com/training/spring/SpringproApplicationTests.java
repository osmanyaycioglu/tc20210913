package com.training.spring;

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
import com.training.spring.employeep.Employee;
import com.training.spring.employeep.EmployeeOperation;
import com.training.spring.employeep.EmployeeRest;
import com.training.spring.employeep.EmployeeService;

@WebMvcTest(EmployeeRest.class)
@AutoConfigureMockMvc
class SpringproApplicationTests {


    @Autowired
    MockMvc           mockMvc;

    @Autowired
    ObjectMapper      om;

    @MockBean
    EmployeeService   es;

    @MockBean
    EmployeeOperation eo;


    @Test
    void contextLoads() throws Exception {
        Employee emp = new Employee();
        emp.setName("osman");
        emp.setSurname("test");
        MvcResult andReturnLoc = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employee/provision/greet")
                                                                            .contentType(MediaType.APPLICATION_JSON)
                                                                            .content(this.om.writeValueAsBytes(emp)))
                                             .andExpect(MockMvcResultMatchers.status()
                                                                             .isOk())
                                             .andReturn();
        String contentAsStringLoc = andReturnLoc.getResponse()
                                                .getContentAsString();

        Assertions.assertThat(contentAsStringLoc)
                  .isEqualTo("Hello osman test");
    }

}
