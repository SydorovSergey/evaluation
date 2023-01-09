package com.syd.evaluation.api.controller;

import com.syd.evaluation.persistence.entity.Role;
import com.syd.evaluation.service.RoleService;
import com.syd.evaluation.util.annotation.PreAuthorizeAdminOrDepsAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    @PreAuthorizeAdminOrDepsAdmin
    public Iterable<Role> getAll() {
        return roleService.getAll();
    }

    @PatchMapping
    @PreAuthorizeAdminOrDepsAdmin
    public boolean update(Role role) {
        return roleService.update(role);
    }

    @PostMapping
    @PreAuthorizeAdminOrDepsAdmin
    public boolean add(Role role) {
        return roleService.add(role);
    }

    @DeleteMapping("{id}")
    @PreAuthorizeAdminOrDepsAdmin
    public boolean delete(@PathVariable Long id) {
        return roleService.delete(id);
    }
}
