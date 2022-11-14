package com.addmission.controller.form;

import javax.persistence.Id;

public class StudentForm {

    @Id
    private String studentname;
    private String parentname;
    private String age;
    private String address;
    private String phoneno;

    public StudentForm() {
    }

    public StudentForm(String studentname, String parentname, String age, String address, String phoneno) {
        this.studentname = studentname;
        this.parentname = parentname;
        this.age = age;
        this.address = address;
        this.phoneno = phoneno;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
