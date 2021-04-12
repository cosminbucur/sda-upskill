package com.sda.spring.boot.rest.server.repository;

import com.sda.spring.boot.rest.server.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    Book findByTitle(String title);
}
