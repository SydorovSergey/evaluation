package com.syd.evaluation.service;

import com.syd.evaluation.persistence.entity.Employee;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface EmployeeService {

    Iterable<Employee> getAll();

    Employee findById(Long id);

    @Transactional
    boolean add(Employee employee);

    Employee findByIdAndPermit(Long id, SecurityContext context);

    @Transactional
    boolean update(Employee employee);

    boolean delete(Long id);
}