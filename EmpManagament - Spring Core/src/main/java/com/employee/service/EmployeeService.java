package com.employee.service;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeService extends JpaRepository<Employee,Long> {
}
