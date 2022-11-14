package com.webfluxdemo.repository;

import com.webfluxdemo.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee,Long> {
    Mono<Employee> findByEmployeeName(String employeeName);
}
