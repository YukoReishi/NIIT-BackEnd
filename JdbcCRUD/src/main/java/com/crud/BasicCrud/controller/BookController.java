package com.crud.BasicCrud.controller;

import com.crud.BasicCrud.model.BookModel;
import com.crud.BasicCrud.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bservice;

    // ADDING data
    @PostMapping("/add")
    public BookModel addBooks(@RequestBody BookModel model){
        return bservice.addBook(model);
    }

    // VIEWING ALL Data
    @GetMapping("/view")
    public List<BookModel> viewBooksAll(){
        return bservice.viewBookAll();
    }

    // VIEWING DATA BY ID
    @GetMapping("/view/{id}")
    public Optional<BookModel> viewBookById(@PathVariable("id") int id){
        return bservice.viewBookId(id);
    }

    // UPDATING the database
    @PutMapping("/update/{id}")
    public BookModel updateBook(@PathVariable("id") int id, @RequestBody BookModel model){
        return bservice.updateBook(id, model);
    }

    //DELETING the element from the Database
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bservice.deleteBook(id);
    }

}
