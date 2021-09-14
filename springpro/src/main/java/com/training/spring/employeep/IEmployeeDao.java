package com.training.spring.employeep;

import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDao extends CrudRepository<Employee, Long> {

}
