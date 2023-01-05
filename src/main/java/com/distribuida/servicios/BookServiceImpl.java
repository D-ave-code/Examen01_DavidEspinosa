package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ApplicationScoped
public class BookServiceImpl implements BookService{
    private List<Book> books = new ArrayList<>();
    private Integer nextId = 1;

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Book findById(Integer id) {
        Book bookc = new Book();

        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == id){
                bookc = books.get(i);
    break;
            }
        }
        return bookc;

    }

    public Book create(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    public Book update(Book book) {
        Book b= null;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i,book);
               b= book;
            }
        }
        return b;
    }

    public void delete(Integer id) {
        Book book = findById(id);
        if (book != null) {
            books.remove(book);
        }
    }
}
