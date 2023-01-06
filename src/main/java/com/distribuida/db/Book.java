package com.distribuida.db;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Data
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private String author;
    private Double price ;
}
