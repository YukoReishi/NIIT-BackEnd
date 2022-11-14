package com.studentmicroservice.service;

import com.studentmicroservice.model.Student;
import com.studentmicroservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student student){
        return repo.save(student);
    }

    public List<Student> viewStudent(){
        return repo.findAll();
    }

    public Student updateStudent(long rollno, Student student){
        return repo.save(student);
    }

    public void deleteStudent(long rollno){
        repo.deleteById(rollno);
    }
}
