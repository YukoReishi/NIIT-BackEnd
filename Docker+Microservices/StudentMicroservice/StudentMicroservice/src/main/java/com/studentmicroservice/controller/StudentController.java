package com.studentmicroservice.controller;

import com.studentmicroservice.model.Student;
import com.studentmicroservice.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping("/view")
    public List<Student> viewStudent(){
        return service.viewStudent();
    }

    @PutMapping("/update/{rollno}")
    public Student updateStudent(@PathVariable("rollno") long rollno, @RequestBody Student student){
        return service.updateStudent(rollno, student);
    }
}
