package com.syd.evaluation.util;

import com.google.common.collect.Sets;
import com.syd.evaluation.persistence.entity.Department;
import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.persistence.entity.Role;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContext;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class EmployeeUtil {

    public Employee getEmployeeFromSecurityContext(SecurityContext securityContext) {
        Object obj = securityContext.getAuthentication().getPrincipal();
        return obj instanceof Employee employee ? employee : null;
    }

    public boolean isAdmin(Employee employee) {
        return employee.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    public boolean isAdminDepartments(Employee employee) {
        return employee.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN_DEPARTMENTS"));
    }

    public boolean isAdminOrDepsAdmin(Employee employee){
       return employee.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))
               || employee.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN_DEPARTMENTS"));
    }

    public boolean isAdminSameDepartment(Employee admin, Employee employee) {
        if (isAdmin(admin) || isAdminDepartments(admin)) return true;
        if (validDepartment(admin).isEmpty()) return false;
        Sets.SetView<String> difference = Sets.intersection(new HashSet<>(validDepartment(admin)), employee.getDepartments().stream().map(Department::getName).collect(Collectors.toSet()));
        return !difference.isEmpty();
    }

    public List<String> validDepartment(Employee employee) {
        List<Role> roles = employee.getRoles().stream()
                .filter(value ->
                        value.getName()
                                .toUpperCase()
                                .contains("ROLE_ADMIN_DEPARTMENT"))
                .toList();
        return roles.stream()
                .map(e -> e.getName()
                        .replaceAll("ROLE_ADMIN_DEPARTMENT_", ""))
                .toList();
    }

}
