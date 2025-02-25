package com.book.bookApp.repo;

import com.book.bookApp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);
}
