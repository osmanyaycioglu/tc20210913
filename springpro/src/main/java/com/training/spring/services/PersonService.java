package com.training.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.database.IPersonDao;
import com.training.spring.model.Person;

@Service
public class PersonService {

    @Autowired
    private IPersonDao   pDao;

    @Autowired
    private PersonFacade pf;


    @Transactional(propagation = Propagation.REQUIRED)
    public void add(final Person personParam) {
        this.pDao.save(personParam);
        // this.pf.add(personParam);
    }

    @Lock(LockModeType.OPTIMISTIC)
    public void update(final Person personParam) {
        Optional<Person> findByIdLoc = this.pDao.findById(personParam.getPersonId());
        this.pDao.save(personParam);
    }

    public void delete(final long personId) {
        this.pDao.deleteById(personId);
    }

    public Person getOne(final long personId) {
        return this.pDao.findById(personId)
                        .orElse(null);
    }

    public List<Person> getByName(final String name) {
        return this.pDao.findByName(name);
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
