package com.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hid;
    private String hname;
    private String hroomPrice;
    private String city;


    public Hotel() {
        super();
    }

    public Hotel(String hname, String hroomPrice, String city) {
        this.hname = hname;
        this.hroomPrice = hroomPrice;
        this.city = city;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHroomPrice() {
        return hroomPrice;
    }

    public void setHroomPrice(String hroomPrice) {
        this.hroomPrice = hroomPrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String hcity) {
        this.city = hcity;
    }

}
