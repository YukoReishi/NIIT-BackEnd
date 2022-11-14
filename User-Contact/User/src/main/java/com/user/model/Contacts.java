package com.user.model;

public class Contacts {
    private Long cId;
    private String email;

    private String phone;

    private String address;
    private Long userId;

    public Contacts() {
        super();
    }

    public Contacts(Long cId, String email,String phone,String address, Long userId) {
        this.cId = cId;
        this.email = email;
        this.address=address;
        this.userId = userId;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
