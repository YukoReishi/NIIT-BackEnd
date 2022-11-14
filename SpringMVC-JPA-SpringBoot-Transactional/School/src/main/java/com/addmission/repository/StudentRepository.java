package com.addmission.repository;

import com.addmission.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
