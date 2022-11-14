package com.crud.BasicCrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookModel {
    @Id
    private int bid;
    private String bname;
    private String bauthor;
    private int bprice;
}
