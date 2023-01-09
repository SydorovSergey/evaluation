package com.syd.evaluation.service;

import com.syd.evaluation.persistence.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface RoleService{


    Iterable<Role> getAll();

    @Transactional
    boolean update(Role role);

    @Transactional
    boolean add (Role role);

    @Transactional
    boolean delete(Long id);
}
