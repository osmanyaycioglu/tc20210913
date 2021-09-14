package com.training.spring.database;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.model.Phone;

public interface IPhoneDao extends CrudRepository<Phone, Long> {


}
