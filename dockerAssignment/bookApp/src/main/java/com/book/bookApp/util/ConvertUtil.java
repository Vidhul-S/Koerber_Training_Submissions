package com.book.bookApp.util;

import com.book.bookApp.dto.BookDto;
import com.book.bookApp.entities.Book;

public class ConvertUtil {
    public static Book convertToBook(BookDto BookDto) {
        return new Book(BookDto.getId(),BookDto.getIsbn(), BookDto.getTitle(), BookDto.getAuthor(), BookDto.getPrice());
    }
    public static BookDto convertToBookDto(Book book) {
        return new BookDto(book.getId(),book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice());
    }
}
