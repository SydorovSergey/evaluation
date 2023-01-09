package com.syd.evaluation.service.impl;

import com.syd.evaluation.persistence.entity.Department;
import com.syd.evaluation.persistence.repository.DepartmentRepository;
import com.syd.evaluation.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public boolean update(Department department) {
        departmentRepository.findById(department.getId()).ifPresent(dep -> {
            dep.setActive(department.getActive());
            dep.setName(department.getName());
            departmentRepository.save(dep);
        });
        return true;
    }

    @Override
    public boolean add(Department department) {
        departmentRepository.save(department);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        departmentRepository.findById(id).ifPresent(department -> {
            department.setActive(false);
            departmentRepository.save(department);
        });
        return true;
    }
}
