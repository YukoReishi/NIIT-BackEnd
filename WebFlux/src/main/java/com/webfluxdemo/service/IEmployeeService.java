package com.webfluxdemo.service;

import com.webfluxdemo.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
    Mono<Employee> addEmployee(Employee employee);
    Mono<Employee> findEmployeeByEmployeeName(String employeename);
    Flux<Employee> getallEmployeeDetails();
    Mono<Employee> deleteEmployeeByEmplyeeId(Long employeeId);

}
