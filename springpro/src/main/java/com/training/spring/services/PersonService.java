package com.training.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.Person;
import com.training.spring.database.IPersonDao;

@Service
public class PersonService {

    @Autowired
    private IPersonDao pDao;

    public void add(final Person personParam) {
        this.pDao.save(personParam);
    }

    public void update(final Person personParam) {
        this.pDao.save(personParam);
    }

    public void delete(final long personId) {
        this.pDao.deleteById(personId);
    }

    public Person getOne(final long personId) {
        return this.pDao.findById(personId)
                        .orElse(null);
    }

    public List<Person> getAll() {
        List<Person> listLoc = new ArrayList<>();
        Iterable<Person> findAllLoc = this.pDao.findAll();
        for (Person personLoc : findAllLoc) {
            listLoc.add(personLoc);
        }
        return listLoc;
    }


}
