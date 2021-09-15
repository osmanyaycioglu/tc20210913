package com.training.spring.employeep;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDao extends CrudRepository<Employee, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("select e from Employee e where e.personId=?1")
    Employee takeEmployee(Long empId);

}
