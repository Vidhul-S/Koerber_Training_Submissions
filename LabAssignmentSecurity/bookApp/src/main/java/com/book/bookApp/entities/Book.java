package com.book.bookApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "account")
public class Book {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(name = "isbn_of_the_book")
    private String isbn;
    @Column(name = "title_of_the_book")
    private String title;
    @Column(name = "author_of_the_book")
    private String author;
    @Column(name = "price_of_the_book")
    private double price;

    public Book(String isbn, String title, String author, double price) {
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.price=price;
    }
}
