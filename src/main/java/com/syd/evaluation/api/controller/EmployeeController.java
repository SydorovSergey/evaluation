package com.syd.evaluation.api.controller;

import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.service.EmployeeService;
import com.syd.evaluation.util.annotation.PreAuthorizeAdminOrDepsAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    @PreAuthorizeAdminOrDepsAdmin
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.findByIdAndPermit(id, SecurityContextHolder.getContext());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }
}
