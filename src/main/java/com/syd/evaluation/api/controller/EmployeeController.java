package com.syd.evaluation.api.controller;

import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }
}
