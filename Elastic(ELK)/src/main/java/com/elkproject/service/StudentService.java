package com.elkproject.service;

import com.elkproject.model.Student;
import com.elkproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // Posting the Data
    public Student addStudent(Student student){
        return repo.save(student);
    }

    // Listing all the Data
    public List<Student> viewStudent(){
        return repo.findAll();
    }

    // Updating the Data
    public Student updateStudent(long rollno, Student student){
        return repo.save(student);
    }

    // Deleting the Data
    public void deleteData(long rollno){
        repo.deleteById(rollno);
    }
}
