package com.sda.spring.boot.rest.service;

import com.sda.spring.boot.rest.server.dto.BookRequest;
import com.sda.spring.boot.rest.server.dto.BookResponse;
import com.sda.spring.boot.rest.server.service.BookAdvancedService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BookServiceIntegrationTest {

    @Autowired
//    private BookService bookService;
    private BookAdvancedService bookService;

    @BeforeEach
    void setUp() {
        bookService.findAll().forEach(
                bookResponse -> bookService.delete(bookResponse.getId())
        );
    }

    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("title");
        request.setAuthor("author");
        request.setPublished(LocalDate.of(2000, 6, 30));

        // when
        BookResponse actual = bookService.save(request);

        BookResponse expected = new BookResponse();
        expected.setId(actual.getId());
        expected.setTitle("title");
        expected.setAuthor("author");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenExistingBook_whenSave_thenThrowException() {
        // given
        // setup initial db state
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        bookService.save(bookRequest);

        // then
        assertThrows(RuntimeException.class,
                // when
                () -> bookService.save(bookRequest));
    }

    @Test
    void given2Books_whenFindAll_thenReturn2Responses() {
        // given
        BookRequest request1 = new BookRequest();
        request1.setTitle("title1");
        request1.setAuthor("author");
        request1.setPublished(LocalDate.of(2000, 6, 30));

        BookRequest request2 = new BookRequest();
        request2.setTitle("title2");
        request2.setAuthor("author");
        request2.setPublished(LocalDate.of(2001, 6, 30));

        bookService.save(request1);
        bookService.save(request2);

        // when
        List<BookResponse> actual = bookService.findAll();

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void givenValidId_whenFindById_thenReturnBookResponse() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse savedBook = bookService.save(bookRequest);

        // when
        BookResponse actual = bookService.findById(savedBook.getId());

        // then
        assertThat(actual.getTitle()).isEqualTo(bookRequest.getTitle());
    }

    @Test
    void givenInvalidId_whenFindById_thenThrowException() {
        assertThrows(RuntimeException.class,
                () -> bookService.findById(1L));
    }

    @Test
    void given2BooksSameAuthor_whenFindByAuthor_thenReturn2Books() {
        // given
        BookRequest request1 = new BookRequest();
        request1.setTitle("title1");
        request1.setAuthor("author");
        request1.setPublished(LocalDate.of(2000, 6, 30));

        BookRequest request2 = new BookRequest();
        request2.setTitle("title2");
        request2.setAuthor("author");
        request2.setPublished(LocalDate.of(2001, 6, 30));

        bookService.save(request1);
        bookService.save(request2);

        // when
        List<BookResponse> actual = bookService.findByAuthor("author");

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void givenBook_whenUpdate_thenReturnUpdatedBook() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("title1");
        request.setAuthor("author1");
        request.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse savedBook = bookService.save(request);

        BookRequest updateRequest = new BookRequest();
        updateRequest.setTitle("title2");
        updateRequest.setAuthor("author2");
        updateRequest.setPublished(LocalDate.of(2001, 6, 30));

        // when
        BookResponse actual = bookService.update(savedBook.getId(), updateRequest);

        // then
        assertThat(actual.getTitle()).isEqualTo(updateRequest.getTitle());
    }

    @Test
    void givenBook_whenDelete_thenDbIsEmpty() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("title");
        request.setAuthor("author");
        request.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse savedBook = bookService.save(request);
        int sizeBefore = bookService.findAll().size();

        // when
        bookService.delete(savedBook.getId());
        int sizeAfter = bookService.findAll().size();

        // then
        assertThat(sizeBefore).isGreaterThan(sizeAfter);
    }

}