package com.training.spring.database;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.model.Person;

@Transactional(readOnly = true)
public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findAllByName(String name);

    //    @Modifying
    //    @Transactional
    //    @Query(name = "update Person p set p.name=?1 where p.personId=?2")
    //    void updateNameById(String name,
    //                        Long personId);

    @Query(name = "Person.findAllByName")
    List<Person> findAllByNameEx(String name);

    List<Person> findAllByNameAndSurname(String name,
                                         String surname);

    @Query("select p from Person p where p.name=?1")
    List<Person> searchName(String name);

    @Query("select p from Person p where p.name=:isim")
    List<Person> searchName2(@Param("isim") String name);

    @Query(value = "select * from operson p where p.name=?1", nativeQuery = true)
    List<Person> searchNameNative(String name);

    @Query("select p.personId,p.name from Person p where p.name=?1")
    List<Object[]> searchNameGetIdAndName(String name);

    @Query("select p.personId,LENGTH(p.name) from Person p where p.name=?1")
    List<Object[]> searchNameGetIdAndNameLength(String name);

    // List<Person> findByNameIn(List<String> name);

    @Async("threadPoolTaskExecutor")
    Future<List<Person>> findByNameIn(List<String> name);

    List<Person> findByNameLike(String namelike);

    List<Person> findByNameStartsWith(String prefix);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    List<Person> findByNameOrSurname(String name,
                                     String surname);

    List<Person> findTop10ByName(String name);

    Person findOneByNameOrderByName(String name);

    List<Person> deleteByName(String name);


}
