package com.books.repository.impl;

import com.books.exceptions.DaoException;
import com.books.factory.ConnectionFactory;
import com.books.repository.Book;
import com.books.repository.BookRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepoJdbcImpl implements BookRepo {

    private final Connection connection;

    public BookRepoJdbcImpl() {
        this.connection = ConnectionFactory.getConnection();
    }


    @Override
    public List<Book> getAllBooks() throws DaoException {

        List<Book> books = new ArrayList<>();
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books");
            while (rs.next()) {
                books
                        .add(new Book(
                                rs.getInt("id"),
                                rs.getString("isbn"),
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into books(isbn, title, author, price) values(?,?,?,?)");

            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public boolean deleteBook(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from books where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(int id, Book book) throws DaoException {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE books SET isbn=?,title=?,author=?,price=? WHERE id=?");
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setInt(5, id);
            int noOfRecordEffected = preparedStatement.executeUpdate();

            System.out.println(noOfRecordEffected);
            result = noOfRecordEffected == 1 ? true : false;

        } catch (SQLException e) {
            throw new DaoException("No Book at " + id, e);
        }
        finally {
            return result;
        }
    }


    @Override
    public Book getBookById(int id) throws DaoException {
        Book book = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books WHERE id=" + id);
            while (rs.next()) {
                book = new Book(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"));
            }
        } catch (SQLException e) {
            throw new DaoException("No Book at " + id, e);
        }
        return book;
    }
}