package com.sda.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookJdbcDaoIntegrationTest {

    private static final BookRepository bookRepository = new BookJdbcMysqlDao();
    private static final BookRepository bookRepository2 = new BookJdbcInMemoryDao();

    @BeforeEach
    void setUp() {
        bookRepository.findAll()
                .forEach(book -> bookRepository.delete(book.getId()));
    }

    @Test
    void givenBook_whenCreate_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishDate(LocalDate.of(2010, 1, 20));

        // when
        Book actualBook = bookRepository.create(book);

        // then
        assertThat(actualBook.getId()).isNotNull();
    }

    @Test
    void given2Books_whenFindAll_thenReturnBookList() {
        // given
        Book book1 = new Book();
        book1.setTitle("book1");
        book1.setAuthor("author1");
        book1.setPublishDate(LocalDate.of(2010, 1, 20));

        Book book2 = new Book();
        book2.setTitle("book2");
        book2.setAuthor("author2");
        book2.setPublishDate(LocalDate.of(2010, 1, 20));

        bookRepository.create(book1);
        bookRepository.create(book2);

        // when
        List<Book> actualBooks = bookRepository.findAll();

        // then
        assertThat(actualBooks).hasSize(2);
    }

    @Test
    void given2BooksWithSameAuthor_whenFindByAuthor_thenReturn2Books() {
        // given
        String sameAuthor = "author";

        Book book1 = new Book();
        book1.setTitle("book1");
        book1.setAuthor(sameAuthor);
        book1.setPublishDate(LocalDate.of(2010, 1, 20));

        Book book2 = new Book();
        book2.setTitle("book2");
        book2.setAuthor(sameAuthor);
        book2.setPublishDate(LocalDate.of(2010, 1, 30));

        bookRepository.create(book1);
        bookRepository.create(book2);

        // when
        List<Book> actual = bookRepository.findByAuthor(sameAuthor);

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void givenBook_whenFindById_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishDate(LocalDate.of(2010, 1, 20));

        Book savedBook = bookRepository.create(book);

        // when
        Book actual = bookRepository.findById(savedBook.getId()).get();

        // then
        assertThat(actual.getId()).isEqualTo(savedBook.getId());
    }

    @Test
    void givenBook_whenFindByTitle_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishDate(LocalDate.of(2010, 1, 20));

        Book savedBook = bookRepository.create(book);

        // when
        Book actual = bookRepository.findByTitle(savedBook.getTitle()).get();

        // then
        assertThat(actual.getTitle()).isEqualTo(savedBook.getTitle());
    }

    @Test
    void givenBook_whenUpdate_thenReturnUpdatedBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishDate(LocalDate.of(2010, 1, 20));

        Book bookToUpdate = bookRepository.create(book);

        Book bookData = new Book();
        bookData.setTitle("title");
        bookData.setAuthor("author");
        bookData.setPublishDate(LocalDate.of(2010, 1, 20));

        // when
        Book updatedBook = bookRepository.update(bookToUpdate.getId(), bookData);

        // then
        assertThat(updatedBook.getTitle()).isEqualTo(bookData.getTitle());
    }

    @Test
    void givenBook_whenDelete_shouldDeleteFromDatabase() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishDate(LocalDate.of(2020, 10, 10));

        Book bookToDelete = bookRepository.create(book);

        // when
        bookRepository.delete(bookToDelete.getId());

        // then
        assertThat(bookRepository.findByAuthor("author")).isNullOrEmpty();
    }

}