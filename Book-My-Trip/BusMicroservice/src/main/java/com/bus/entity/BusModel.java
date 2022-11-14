package com.bus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sqno;
    private String busid;
    private String bname;
    private String source;
    private String destination;
    private String bclass;
    private String price;
}
