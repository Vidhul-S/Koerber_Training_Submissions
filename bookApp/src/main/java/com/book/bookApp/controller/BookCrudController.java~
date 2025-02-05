package com.book.bookApp.controller;

import com.book.bookApp.exceptions.BookNotFoundException;
import com.book.bookApp.service.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.book.bookApp.dto.BookDto;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bankapp")
public class BookCrudController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    //get all account
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookServiceImpl.getAllBooks());
    }

    //get account by id
    @GetMapping("/book/id/{id}")
    public ResponseEntity<BookDto> getBookById(@Valid @PathVariable int id){
        try {
            BookDto account = bookServiceImpl.getBookById(id);
            return ResponseEntity.ok(account);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    //get account by isbn
    @GetMapping("/book/isbn/{isbn}")
    public ResponseEntity<BookDto> getBookByIsbn(@Valid @PathVariable String isbn){
        try {
            BookDto account = bookServiceImpl.getBookByIsbn(isbn);
            return ResponseEntity.ok(account);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //get account by title
    @GetMapping("/book/title/{title}")
    public ResponseEntity<BookDto> getBookByTitle(@Valid @PathVariable String title) {
        try {
            BookDto account = bookServiceImpl.getBookByTitle(title);
            return ResponseEntity.ok(account);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    //get account by author
    @GetMapping("/book/author/{author}")
    public ResponseEntity<BookDto> getBookByAuthor(@Valid @PathVariable String author) {
        try {
            BookDto account = bookServiceImpl.getBookByAuthor(author);
            return ResponseEntity.ok(account);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //addBook
    @PutMapping("/addBook")
    public ResponseEntity<String> addBook(@Valid @RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookServiceImpl.addBook(bookDto));
    }

    //removeBook
    @DeleteMapping("/removeBook")
    public ResponseEntity<String> removeBook(@Valid @RequestBody BookDto bookDto){
        try {
            String result = bookServiceImpl.removeBook(bookDto);
            return ResponseEntity.ok(result);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No book to be removed ");
        }
    }
}
