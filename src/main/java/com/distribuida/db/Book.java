package com.distribuida.db;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {
    private Integer id;
    private String isbn;
    private String title;
    private String autor;
    private Double price ;
}
