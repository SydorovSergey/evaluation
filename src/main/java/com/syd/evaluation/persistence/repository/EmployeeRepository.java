package com.syd.evaluation.persistence.repository;

import com.syd.evaluation.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByEmail(String email);
    Employee findByEmailAndActiveIsTrue(String email);
}
