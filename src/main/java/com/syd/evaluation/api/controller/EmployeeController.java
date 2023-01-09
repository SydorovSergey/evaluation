package com.syd.evaluation.api.controller;

import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.service.EmployeeService;
import com.syd.evaluation.util.annotation.PreAuthorizeAdminOrDepsAdmin;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    @Operation(summary = "Get list of employees considering roles and departments")
    public Iterable<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get employee by id and considering roles and departments")
    public Employee getById(@PathVariable Long id) {
        return employeeService.findByIdAndPermit(id, SecurityContextHolder.getContext());
    }

    @PostMapping
    @PreAuthorizeAdminOrDepsAdmin
    @Operation(summary = "Add new employee")
    public boolean add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @PatchMapping
    @Operation(summary = "Update employee")
    public boolean update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }


    @DeleteMapping("{id}")
    @Operation(summary = "Delete employee",description = "Sets status active true/false")
    @PreAuthorizeAdminOrDepsAdmin
    public boolean delete(@PathVariable Long id){
        return employeeService.delete(id);
    }
}
