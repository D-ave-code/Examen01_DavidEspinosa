package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jakarta.json.Json;
import jakarta.json.JsonObject;


@ApplicationScoped
public class BookServiceImpl implements BookService{
    private List<Book> books = new ArrayList<>();
    private Integer nextId = 1;
    @Inject
    private DbConfig dbConfig;

    public List<Book> findAll() {
        List<Book> books1 = null;
        String sql = "SELECT * FROM books";
        try (Handle handle = dbConfig.test()) {

            books1 = handle.createQuery(sql)
                    .mapToBean(Book.class)
                    .list();
        }

        return books1;
    }

    public JsonObject findById(Integer id) {
        Book bookd = null;
        JsonObject json;
        String sql = "SELECT * FROM books where id = " + id;
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        List<Book> books1=findAll();
        List<Book> books = null;
        List<Book> books2 = null;
        try (Handle handle = dbConfig.test()) {
            books =  handle.createQuery(sql)
                    .mapToBean(Book.class)
                    .list();
        }
        //return books.get(0);






        if(books.size() > 0){
            arrayBuilder.add(Json.createObjectBuilder().add("id", books.get(0).getId()).add("isbn", books.get(0).getIsbn())
                    .add("title", books.get(0).getTitle()).add("author", books.get(0).getAuthor())
                    .add("price", books.get(0).getPrice()).build());
            bookd = books.get(0);
            json = Json.createObjectBuilder()
                    .add("existe", "SI")
                    .add("data", arrayBuilder.build())

                    .build();
        }else {
            json = Json.createObjectBuilder()
                    .add("existe", "NO")
                    .build();
        }


        return json;


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
      //  Book book = findById(id);
     //   if (book != null) {
      //      books.remove(book);
       // }
    }
}
