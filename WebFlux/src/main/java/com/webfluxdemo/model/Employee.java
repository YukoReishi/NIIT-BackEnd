package com.webfluxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee{
    @Id
    private Long employeeId;
    private String employeeName;
    private double employeeSalary;

}
