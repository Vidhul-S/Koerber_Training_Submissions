package com.book.service;

import com.book.dao.BookDao;
import com.book.dao.BookDaoJdbcImpl;
import com.book.model.Book;
import com.book.util.Loggable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDaoJdbcImpl dao; // this(final keyword) will force jdk to create the constructor
                                       // and hence making it a constructor injected bean

    @Loggable
    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Loggable
    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Loggable
    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Loggable
    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Loggable
    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

}
