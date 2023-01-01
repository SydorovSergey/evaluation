package com.syd.evaluation.service.impl;

import com.syd.evaluation.persistence.entity.Employee;
import com.syd.evaluation.persistence.repository.EmployeeRepository;
import com.syd.evaluation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository employeeRepository; 
    
    @Override
    public Flux<Employee> getAll() {
        return Flux.fromIterable(employeeRepository.findAll());
    }

    @Override
    public Mono<Employee> findById(Long id) {
        return Mono.just(employeeRepository.findById(id).orElse(new Employee()));
    }
}
