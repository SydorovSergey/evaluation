package com.syd.evaluation.service.impl;

import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.persistence.repository.EmployeeRepository;
import com.syd.evaluation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }
}
