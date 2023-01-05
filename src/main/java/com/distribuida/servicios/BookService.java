package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    Book findById(Integer id);
    List<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(Integer id);

}
