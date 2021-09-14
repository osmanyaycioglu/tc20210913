package com.training.spring.database;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.training.spring.model.Person;

@NoRepositoryBean
public interface IPersonDaoEx extends JpaRepository<Person, Long> {

    List<Person> findByName(String name,
                            Pageable pageable);

    List<Person> findByNameSort(String name,
                                Sort sort);

    @Query(countQuery = "select COUNT(p) from Person p where p.name=?1",
           value = "select p from Person p where p.name=?1")
    List<Person> searchName(String name,
                            Pageable pageable);
}
