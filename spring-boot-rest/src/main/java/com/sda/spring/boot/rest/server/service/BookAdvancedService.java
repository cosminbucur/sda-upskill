package com.sda.spring.boot.rest.server.service;

import com.sda.spring.boot.rest.server.dto.BookMapper;
import com.sda.spring.boot.rest.server.dto.BookRequest;
import com.sda.spring.boot.rest.server.dto.BookResponse;
import com.sda.spring.boot.rest.server.model.Book;
import com.sda.spring.boot.rest.server.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookAdvancedService {

    private static final Logger log = LoggerFactory.getLogger(BookAdvancedService.class);
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookAdvancedService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    // CRUD

    public BookResponse save(BookRequest request) {
        log.debug("saving book {}", request);

        Book existingBook = bookRepository.findByTitle(request.getTitle());
        if (existingBook != null) {
            throw new RuntimeException("book already exists");
        }

        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    public List<BookResponse> findAll() {
        log.debug("find all books");

        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookResponse findById(Long id) {
        log.debug("find author by id: {}", id);

        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new RuntimeException("book not found"));
    }

    public List<BookResponse> findByAuthor(String author) {
        log.debug("find books by author: {}", author);

        return bookRepository.findByAuthor(author).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookResponse update(Long id, BookRequest request) {
        log.debug("updating book id: {} and request body : {}", id, request);

        return bookRepository.findById(id)
                .map(author -> bookMapper.toEntity(author, request))
                .map(bookRepository::save)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new RuntimeException(("book not found")));
    }

    public void delete(Long id) {
        log.debug("deleting author with id: {}", id);

        bookRepository.deleteById(id);
    }

}
