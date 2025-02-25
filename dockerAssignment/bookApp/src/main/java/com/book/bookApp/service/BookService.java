package com.book.bookApp.service;

import com.book.bookApp.dto.BookDto;
import java.util.List;

public interface BookService {
    public List<BookDto> getAllBooks();
    public BookDto getBookById(int id);
    public BookDto getBookByIsbn(String isbn);
    public BookDto getBookByTitle(String title);
    public BookDto getBookByAuthor(String author);
    public String addBook(BookDto bookDto);
    public String removeBook(BookDto bookDto);
}
