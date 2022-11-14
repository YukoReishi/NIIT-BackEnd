package com.addmission.service;

import com.addmission.controller.form.StudentForm;
import com.addmission.model.Student;
import com.addmission.model.StudentClass;
import com.addmission.repository.StudentClassRepository;
import com.addmission.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentClassService {

    @Autowired
    private StudentRepository studentrepo;

    @Autowired
    private StudentClassRepository classrepo;

    // Adding the Data
    public String addDetails(StudentForm form){
        Student student = new ObjectMapper().convertValue(form, Student.class);
        String name = studentrepo.save(student).getStudentname();

        StudentClass studentclass = new StudentClass(10416210017L, "Sixth", "A", "Preeti", name);
        String cname = classrepo.save(studentclass).getSclass();
        return "Student Class Assigned" + cname;
    }

    // Viewing the Student Data
    public List<Student> viewStudents (){
        return studentrepo.findAll();
    }

    // Viewing the Class Student Data
    public List<StudentClass> viewStudentsClass (){
        return classrepo.findAll();
    }

    // Update the Student data
    public Student updateStudent(int id, Student student){
        return studentrepo.save(student);
    }

    // Update the Class Data
    public StudentClass updateClass(long id, StudentClass studentclass){
        return classrepo.save(studentclass);
    }

    // Delete the Student Data
    public void deleteStudent(int id){
        studentrepo.deleteById(id);
    }

    // Delete The Student Class
    public void deleteClass(int id){
        classrepo.deleteById(id);
    }
}
