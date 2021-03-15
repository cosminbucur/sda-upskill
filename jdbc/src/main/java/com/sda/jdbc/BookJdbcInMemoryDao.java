package com.sda.jdbc;

import java.util.*;
import java.util.stream.Collectors;

// implement using a map as an in-memory database
public class BookJdbcInMemoryDao implements BookRepository {

    private static Map<Long, Book> db = new HashMap<>();

    @Override
    public Book create(Book book) {
        long nextId = db.size() + 1L;
        book.setId(nextId);
        db.put(nextId, book);
        return db.get(nextId);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return db.values().stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(db.get(id));
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return db.values().stream().findFirst();
    }

    @Override
    public Book update(Long id, Book book) {
        Book bookToUpdate = db.get(id);

        if (id != null) {
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setPublishDate(book.getPublishDate());
            return bookToUpdate;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        db.remove(id);
    }

}
