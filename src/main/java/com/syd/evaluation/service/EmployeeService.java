package com.syd.evaluation.service;

import com.syd.evaluation.persistence.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<Employee> getAll();

    Mono<Employee> findById(Long id);
}