package com.studentmicroservice.controller;

import com.studentmicroservice.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentControllerSecond {

    @Autowired
    private StudentServiceImpl services;

    @DeleteMapping("/delete/{rollno}")
    public void deleteStudent(@PathVariable("rollno") long rollno){
        services.deleteStudent(rollno);
    }
}
