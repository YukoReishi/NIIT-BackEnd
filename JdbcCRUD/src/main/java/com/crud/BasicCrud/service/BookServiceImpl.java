package com.crud.BasicCrud.service;

import com.crud.BasicCrud.model.BookModel;
import com.crud.BasicCrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookServiceImpl implements IBookService{

    @Autowired
    private BookRepository bookrepo;

    // Adding the elements in the database
    @Override
    public BookModel addBook(BookModel model){
        return bookrepo.save(model);
    }

    // Viewing the elements from the database
    @Override
    public List<BookModel> viewBookAll(){
        return bookrepo.findAll();
    }

    // Viewing the elements from the database using id
    @Override
    public Optional<BookModel> viewBookId(int id){
        return bookrepo.findById(id);
    }

    // Updating the elements in the database using id
    @Override
    public BookModel updateBook(int id, BookModel model){
        return bookrepo.save(model);
    }

    // Deleting the element from the database using id
    @Override
    public void deleteBook(int id){
        bookrepo.deleteById(id);
    }
}
