package com.books.repository;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;
}
