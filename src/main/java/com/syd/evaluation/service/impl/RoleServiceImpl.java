package com.syd.evaluation.service.impl;

import com.syd.evaluation.persistence.entity.Role;
import com.syd.evaluation.persistence.repository.RoleRepository;
import com.syd.evaluation.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public boolean update(Role role) {
        roleRepository.findById(role.getId()).ifPresent(r -> {
            r.setActive(role.getActive());
            r.setName(role.getName());
        });
        return true;
    }

    @Override
    public boolean add(Role role) {
        roleRepository.save(role);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        roleRepository.findById(id).ifPresent(role -> {
            role.setActive(false);
            roleRepository.save(role);
        });
        return true;
    }
}
