package com.syd.evaluation.service;

import com.syd.evaluation.persistence.entity.Department;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface DepartmentService {

    Iterable<Department> getAll();

    @Transactional
    boolean update(Department department);

    @Transactional
    boolean add(Department department);

    boolean delete(Long id);
}
