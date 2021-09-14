package com.training.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.database.IPersonDao;
import com.training.spring.model.Person;

@Service
public class PersonFacade {

    @Autowired
    private IPersonDao pDao;

    @Transactional(propagation = Propagation.NESTED)
    public void add(final Person personParam) {
        this.pDao.save(personParam);
        this.pDao.save(personParam);
    }

}
