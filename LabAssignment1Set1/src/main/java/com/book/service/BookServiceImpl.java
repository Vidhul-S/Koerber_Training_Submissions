package com.book.service;

import com.book.dao.BookDao;
import com.book.dao.BookDaoImpl;
import com.book.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class BookServiceImpl  implements BookService {

    private final BookDao dao;

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

}
