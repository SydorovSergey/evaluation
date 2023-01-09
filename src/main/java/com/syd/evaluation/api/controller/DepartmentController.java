package com.syd.evaluation.api.controller;

import com.syd.evaluation.persistence.entity.Department;
import com.syd.evaluation.service.DepartmentService;
import com.syd.evaluation.util.annotation.PreAuthorizeAdminOrDepsAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    @PreAuthorizeAdminOrDepsAdmin
    public Iterable<Department> getAll() {
        return departmentService.getAll();
    }

    @PostMapping
    @PreAuthorizeAdminOrDepsAdmin
    public boolean add(@RequestBody Department department) {
        return departmentService.add(department);
    }

    @PatchMapping
    @PreAuthorizeAdminOrDepsAdmin
    public boolean update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @DeleteMapping("{id}")
    @PreAuthorizeAdminOrDepsAdmin
    public boolean delete(@PathVariable Long id) {
        return departmentService.delete(id);
    }
}
