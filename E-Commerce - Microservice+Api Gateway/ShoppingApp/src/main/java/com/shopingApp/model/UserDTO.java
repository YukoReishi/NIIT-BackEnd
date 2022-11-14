package com.shopingApp.model;

public class UserDTO {
    private String customerName;
    private String customerGender;
    private int customerAge;
    private String customerAddress;

    public UserDTO() {
        super();
    }

    public UserDTO(String customerName, String customerGender, int customerAge, String customerAddress) {
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerAge = customerAge;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
