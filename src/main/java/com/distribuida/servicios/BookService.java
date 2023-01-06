package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.List;

public interface BookService {
    JsonObject findById(Integer id);
    List<Book> findAll();
    Book create(Book book);
    JsonObject update(Book book);
    JsonObject delete(Integer id);

}
