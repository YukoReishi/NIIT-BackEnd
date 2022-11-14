package com.webfluxdemo.controller;

import com.webfluxdemo.model.Employee;
import com.webfluxdemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/add-employee")
    public Mono<Employee> addEmployee(@RequestBody Employee employee){
        return employeeServiceImpl.addEmployee(employee);
    }

    @GetMapping("/get-employeeByName/{employeeName}")
    public Mono<Employee> getEmployeeByName(@PathVariable String employeeName){
        return employeeServiceImpl.findEmployeeByEmployeeName(employeeName);
    }

    @GetMapping("/get-allEmployee")
    public Flux<Employee> getAllEmployee(){
        return employeeServiceImpl.getallEmployeeDetails();
    }

    @DeleteMapping("/delete-employeeById/{employeeid}")
    public Mono<Employee> deleteEmployeeById(@PathVariable Long employeeid){
        return employeeServiceImpl.deleteEmployeeByEmplyeeId(employeeid);
    }

}
