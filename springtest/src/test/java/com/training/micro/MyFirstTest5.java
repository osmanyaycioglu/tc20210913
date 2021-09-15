package com.training.micro;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MyFirstTest5 {

    @Autowired
    private PersonService ps;

    @TestConfiguration
    public static class MyTestConfig {

        @Bean
        @Primary
        public IPersonDao personDao() {
            return new IPersonDao() {

                @Override
                public <S extends Person> Iterable<S> saveAll(final Iterable<S> entitiesParam) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public <S extends Person> S save(final S entityParam) {
                    System.out.println("Mock bean save");
                    return null;
                }

                @Override
                public Optional<Person> findById(final Long idParam) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public Iterable<Person> findAllById(final Iterable<Long> idsParam) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public Iterable<Person> findAll() {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public boolean existsById(final Long idParam) {
                    // TODO Auto-generated method stub
                    return false;
                }

                @Override
                public void deleteById(final Long idParam) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void deleteAllById(final Iterable<? extends Long> idsParam) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void deleteAll(final Iterable<? extends Person> entitiesParam) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void deleteAll() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void delete(final Person entityParam) {
                    // TODO Auto-generated method stub

                }

                @Override
                public long count() {
                    // TODO Auto-generated method stub
                    return 0;
                }

                @Override
                public Person findByName(final String nameParam) {
                    // TODO Auto-generated method stub
                    return null;
                }
            };
        }
    }


    @Test
    public void test_person_rest() {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        personLoc.setHeight(200);
        personLoc.setWeight(100);
        String addLoc = this.ps.add(personLoc);
        Assertions.assertEquals(addLoc,
                                "OK");
    }

}
