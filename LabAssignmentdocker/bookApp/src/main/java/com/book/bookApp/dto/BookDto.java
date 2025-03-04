package com.book.bookApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    @NotNull(message = "isbn is required")
    @NotEmpty(message = "isbn is can't be empty")
    private String isbn;
    @NotNull(message = "title is required")
    @NotEmpty(message = "title is can't be empty")
    private String title;
    @NotNull(message = "author is required")
    @NotEmpty(message = "author is can't be empty")
    private String author;
    @NotNull(message = "price is required")
    @Range(min = 0, message = "price can't be negative")
    private double price;

    public BookDto(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
