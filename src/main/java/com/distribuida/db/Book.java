package com.distribuida.db;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Data
public class Book {
    @ColumnName("id")
    private Integer id;
    @ColumnName("isbn")
    private String isbn;
    @ColumnName("title")
    private String title;
    @ColumnName("author")
    private String author;
    @ColumnName("price")
    private Double price ;
}
