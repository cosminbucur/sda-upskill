package com.sda.spring.jdbc;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book create(Book book);

    List<Book> findAll();

    List<Book> findByAuthor(String author);

    Optional<Book> findById(Long id);

    Optional<Book> findByTitle(String title);

    Book update(Long id, Book book);

    void delete(Long id);

}
