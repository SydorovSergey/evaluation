package com.syd.evaluation.service;

import com.syd.evaluation.persistence.entity.Employee;
import org.springframework.security.core.context.SecurityContext;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee findById(Long id);

    boolean add(Employee employee);

    Employee findByIdAndPermit(Long id, SecurityContext context);
}