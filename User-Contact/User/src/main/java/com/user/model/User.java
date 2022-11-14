package com.user.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long userId;
    private String userName;
    private String userAge;
    List<Contacts> contacts = new ArrayList();

    public User() {
        super();

    }

    public User(Long userId, String userName,String userAge, List<Contacts> contacts) {
        this.userId = userId;
        this.userName = userName;
        this.userAge=userAge;
        this.contacts = contacts;
    }

    public User(Long userId, String userName,String userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge=userAge;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}
