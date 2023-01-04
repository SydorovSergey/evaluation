package com.syd.evaluation.service;

import com.syd.evaluation.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee findById(Long id);

    boolean add(Employee employee);
}