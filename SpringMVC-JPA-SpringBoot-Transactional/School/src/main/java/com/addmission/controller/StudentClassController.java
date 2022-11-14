package com.addmission.controller;

import com.addmission.controller.form.StudentForm;
import com.addmission.model.Student;
import com.addmission.model.StudentClass;
import com.addmission.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentClassController {

    @Autowired
    private StudentClassService service;

    @PostMapping("/addstudent")
    public void adddetails(@RequestBody StudentForm form){
        service.addDetails(form);
    }

    @GetMapping("/viewstudent")
    public List<Student> viewStudents(){
        return service.viewStudents();
    }

    @GetMapping("/viewclass")
    public List<StudentClass> viewClass(){
        return service.viewStudentsClass();
    }

    @PutMapping("/Student/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }

    @PutMapping("/class/{id}")
    public StudentClass updateStudentClass(@PathVariable("id") int id, @RequestBody StudentClass studentClass){
        return service.updateClass(id, studentClass);
    }

    @DeleteMapping("deletestudent/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        service.deleteStudent(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentClass(@PathVariable("id") int id){
        service.deleteClass(id);
    }
}
