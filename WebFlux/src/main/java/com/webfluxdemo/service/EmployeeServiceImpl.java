package com.webfluxdemo.service;

import com.webfluxdemo.model.Employee;
import com.webfluxdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Mono<Employee> addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Mono<Employee> findEmployeeByEmployeeName(String employeeName) {
        return employeeRepo.findByEmployeeName(employeeName);
    }

    @Override
    public Flux<Employee> getallEmployeeDetails() {
        return employeeRepo.findAll();
    }

    @Override
    public Mono<Employee> deleteEmployeeByEmplyeeId(Long employeeId) {
        return employeeRepo.findById(employeeId)
                .flatMap(existingUser -> employeeRepo.delete(existingUser)
                .then(Mono.just(existingUser)));
    }
}
