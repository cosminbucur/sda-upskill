package com.sda.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// TODO: https://www.baeldung.com/spring-jdbc-jdbctemplate
@Repository
public class BookJdbcDao implements BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book create(Book book) {
        String query = "INSERT INTO book (title, author, publish_date) VALUES (? ,?, ?)";

        int result = jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getPublishDate());
        System.out.println("--------- result " + result);
        return new Book();
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = null;
        String query = "SELECT * FROM book";

        return result;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = null;
        String query = "SELECT * FROM book WHERE author = ?";

        return result;
    }

    @Override
    public Optional<Book> findById(Long id) {
        String query = "SELECT * FROM book WHERE id = ?";

        return Optional.empty();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        String query = "SELECT * FROM book WHERE title = ?";
        Book result = null;

        return Optional.ofNullable(result);
    }

    @Override
    public Book update(Long id, Book book) {
        String query = "UPDATE book SET title = ?, author = ?, publish_date = ?  WHERE id = ?";
        Book result = null;

        return result;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM book WHERE id = ? ; ";


    }
}
