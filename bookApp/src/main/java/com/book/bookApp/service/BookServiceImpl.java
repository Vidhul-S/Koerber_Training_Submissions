package com.book.bookApp.service;


import com.book.bookApp.dto.BookDto;
import com.book.bookApp.entities.Book;
import com.book.bookApp.exceptions.BookNotFoundException;
import com.book.bookApp.repo.BookRepo;
import com.book.bookApp.util.ConvertUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
@Transactional
public class BookServiceImpl implements BookService  {

    private final BookRepo bookRepo;
    @Scheduled(fixedRate = 60000)
    @Override
    public List<BookDto> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(ConvertUtil::convertToBookDto)
                .toList();
    }

    @Override
    public BookDto getBookById(int id) {
        return bookRepo.findById(id)
                .map(ConvertUtil::convertToBookDto)
                .orElseThrow (()->new BookNotFoundException("Account of id "+id+" not found"));
    }

    @Override
    public BookDto getBookByIsbn(String isbn) {
        return bookRepo.findByIsbn(isbn)
                .map(ConvertUtil::convertToBookDto)
                .orElseThrow (()->new BookNotFoundException("Book with isbn "+isbn+" not found"));
    }

    @Override
    public BookDto getBookByTitle(String title) {
        return bookRepo.findByTitle(title)
                .map(ConvertUtil::convertToBookDto)
                .orElseThrow (()->new BookNotFoundException("Book with title "+title+" not found"));
    }

    @Override
    public BookDto getBookByAuthor(String author) {
        return bookRepo.findByAuthor(author)
                .map(ConvertUtil::convertToBookDto)
                .orElseThrow (()->new BookNotFoundException("Book by author "+author+" not found"));
    }

    @Override
    public String addBook(BookDto bookDto) {
        Book book = ConvertUtil.convertToBook(bookDto);
        bookRepo.save(book);
        return "addBook done successfully";
    }

    @Override
    public String removeBook(BookDto bookDto) {
        Book book = ConvertUtil.convertToBook(bookDto);
        bookRepo.delete(book);
        return "removeBook done successfully";
    }
}
