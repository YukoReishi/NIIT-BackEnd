package com.crud.BasicCrud.service;

import com.crud.BasicCrud.model.BookModel;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    public BookModel addBook(BookModel model);
    public List<BookModel> viewBookAll();
    public Optional<BookModel> viewBookId(int id);
    public BookModel updateBook(int id, BookModel model);
    public void deleteBook(int id);
}
