package com.syd.evaluation.service.impl;

import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.persistence.repository.EmployeeRepository;
import com.syd.evaluation.service.EmployeeService;
import com.syd.evaluation.util.EmployeeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }

    @Override
    public boolean add(Employee employee) {
        Employee empFromDD = employeeRepository.findByEmail(employee.getEmail());

        if (empFromDD != null) return false;

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);

        return true;
    }

    @Override
    public Employee findByIdAndPermit(Long id, SecurityContext context) {

        Employee requesterEmployee = EmployeeUtil.getEmployeeFromSecurityContext(context);
        Employee empl = employeeRepository.findById(id).orElse(new Employee());

        return requesterEmployee.getId().equals(id)
                || EmployeeUtil.isAdminOrDepsAdmin(requesterEmployee)
                || EmployeeUtil.isAdminSameDepartment(requesterEmployee, empl) ? empl : null;
    }
}
