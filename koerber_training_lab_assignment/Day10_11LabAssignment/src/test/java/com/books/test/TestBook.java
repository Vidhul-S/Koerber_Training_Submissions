package com.books.test;

import com.books.exceptions.BookNotFoundException;
import com.books.repository.Book;
import com.books.repository.BookRepo;
import com.books.services.BookServicesImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class TestBook {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookServicesImp bookServicesImp;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1, "978-3-16-148410-0", "The Great Adventure", "John Doe", 119.99);
    }

    @AfterEach
    void tearDown() {
        book = null;
    }

    @Tag("dev")
    @Test
    void getAllBooks() {
        List<Book> books = Collections.singletonList(book);
        Mockito.when(bookRepo.getAllBooks()).thenReturn(books);

        List<Book> result = bookServicesImp.getAllBooks();
        assertEquals(1, result.size());

    }

    @Tag("dev")
    @Test
    void addBook() {
        Book book = new Book(4, "978-3-16-148410-0", "The Great Adventure", "John Doe", 119.99);
        Mockito.when(bookRepo.addBook(book)).thenReturn(book);
        Book result = bookServicesImp.addBook(book);
        assertNotNull(result);
        assertEquals(result, book);
    }
    @Tag("dev")
    @Test
    void deleteBookSuccess() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.deleteBook(1)).thenReturn(true);
        boolean result = bookServicesImp.deleteBook(bookId);
        assertTrue(result);
    }

    @Tag("dev")
    @Test
    void deleteBookFailure() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.deleteBook(bookId)).thenThrow(new BookNotFoundException("Book Not found"));
        assertThrows(BookNotFoundException.class, () -> bookServicesImp.deleteBook(bookId));
    }

    @Tag("dev")
    @Test
    void updateBookSuccess() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.updateBook(bookId, book)).thenReturn(true);
        boolean result = bookServicesImp.updateBook(bookId, book);
        assertTrue(result);
    }

    @Tag("dev")
    @Test
    void updateBookFailure() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.updateBook(bookId, book)).thenThrow(new BookNotFoundException("Book Not found"));
        assertThrows(BookNotFoundException.class, () -> bookServicesImp.updateBook(bookId, book));
    }

    @Tag("dev")
    @Test
    void getBookByIdSuccess() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.getBookById(bookId)).thenReturn(book);
        Book result = bookServicesImp.getBookById(bookId);
        assertNotNull(result);
        assertEquals("The Great Adventure", result.getTitle());
    }

    @Tag("dev")
    @Test
    void getBookByIdFailure() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.getBookById(bookId)).thenThrow(new BookNotFoundException("Book Not found"));
        assertThrows(BookNotFoundException.class, () -> bookServicesImp.getBookById(bookId));
    }
}