package com.elkproject.controller;

import com.elkproject.model.Student;
import com.elkproject.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    private static final Logger LOG = LogManager.getLogger(StudentController.class);
    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        LOG.info("Adding Student");
        return service.addStudent(student);
    }

    @GetMapping("/view")
    public List<Student> viewStudent(){
        LOG.info("Viewing Students");
        return service.viewStudent();
    }

    @PutMapping("/update/{rollno}")
    public Student updateStudent(@PathVariable("rollno") long rollno, Student student){
        LOG.info("Updating the Student with Roll No: " + rollno);
        return service.updateStudent(rollno, student);
    }

    @DeleteMapping("/delete/{rollno}")
    public void deleteStudent(@PathVariable("rollno") long rollno){
        LOG.info("Deleting the Student with Roll No: " + rollno);
        service.deleteData(rollno);
    }
}
