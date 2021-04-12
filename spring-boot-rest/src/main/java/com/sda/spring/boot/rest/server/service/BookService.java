package com.sda.spring.boot.rest.server.service;

import com.sda.spring.boot.rest.server.dto.BookMapper;
import com.sda.spring.boot.rest.server.dto.BookRequest;
import com.sda.spring.boot.rest.server.dto.BookResponse;
import com.sda.spring.boot.rest.server.exception.DuplicateBookException;
import com.sda.spring.boot.rest.server.exception.NotFoundException;
import com.sda.spring.boot.rest.server.model.Book;
import com.sda.spring.boot.rest.server.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    // CRUD

    public BookResponse save(BookRequest request) {
        log.debug("saving book {}", request);

        Book existingBook = bookRepository.findByTitle(request.getTitle());
        if (existingBook != null) {
            throw new DuplicateBookException("book already exists");
        }

        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    public List<BookResponse> findAll() {
        log.debug("find all books...");

        List<Book> books = bookRepository.findAll();
        return bookMapper.toDto(books);
    }

    public BookResponse findById(Long id) {
        log.debug("find author by id: {}", id);

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("book not found"));
        return bookMapper.toDto(book);
    }

    public List<BookResponse> findByAuthor(String author) {
        log.debug("find books by author: {}", author);

        List<Book> books = bookRepository.findByAuthor(author);
        return bookMapper.toDto(books);
    }

    public BookResponse update(Long id, BookRequest request) {
        log.debug("updating book id: {} and request body : {}", id, request);

        // search entity to update
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("book not found"));

        // update data
        Book updatedBook = bookMapper.toEntity(book, request);

        // save updated entity
        Book savedBook = bookRepository.save(updatedBook);

        // convert to dto
        return bookMapper.toDto(savedBook);
    }

    public void delete(Long id) {
        log.debug("deleting author with id: {}", id);

        bookRepository.deleteById(id);
    }

}
