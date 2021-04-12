package com.sda.spring.boot.rest.service;

import com.sda.spring.boot.rest.server.dto.BookMapper;
import com.sda.spring.boot.rest.server.dto.BookRequest;
import com.sda.spring.boot.rest.server.dto.BookResponse;
import com.sda.spring.boot.rest.server.model.Book;
import com.sda.spring.boot.rest.server.repository.BookRepository;
import com.sda.spring.boot.rest.server.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("title");
        request.setAuthor("author");
        request.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("title");
        mockBook.setAuthor("author");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("title");
        expected.setAuthor("author");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(null);
        when(bookMapper.toEntity(any(BookRequest.class)))
                .thenReturn(mockBook);
        when(bookRepository.save(any(Book.class)))
                .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(expected);

        // when
        BookResponse actual = bookService.save(request);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenExistingBook_whenSave_thenThrowException() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("title");
        mockBook.setAuthor("author");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(mockBook);

        // then
        assertThrows(RuntimeException.class,
                // when
                () -> bookService.save(bookRequest));
    }

    @Test
    void given2Books_whenFindAll_thenReturn2Responses() {
        // given
        Book mockBook1 = new Book();
        mockBook1.setTitle("title1");
        mockBook1.setAuthor("author");
        mockBook1.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook2 = new Book();
        mockBook2.setTitle("title2");
        mockBook2.setAuthor("author");
        mockBook2.setPublished(LocalDate.of(2001, 6, 30));

        BookResponse mockResponse1 = new BookResponse();
        mockResponse1.setTitle("title1");
        mockResponse1.setAuthor("author");
        mockResponse1.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse mockResponse2 = new BookResponse();
        mockResponse2.setTitle("title2");
        mockResponse2.setAuthor("author");
        mockResponse2.setPublished(LocalDate.of(2001, 6, 30));

        when(bookRepository.findAll())
                .thenReturn(Arrays.asList(mockBook1, mockBook2));
        when(bookMapper.toDto(anyList()))
                .thenReturn(List.of(mockResponse1, mockResponse2));

        // when
        List<BookResponse> actual = bookService.findAll();

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void givenValidId_whenFindById_thenReturnBookResponse() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublished(LocalDate.of(2000, 6, 30));

        Optional<Book> mockBook = Optional.of(book);

        BookResponse mockResponse = new BookResponse();
        mockResponse.setId(2L);
        mockResponse.setTitle("title2");
        mockResponse.setAuthor("author2");
        mockResponse.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findById(anyLong()))
                .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(mockResponse);

        // when
        BookResponse actual = bookService.findById(1L);

        // then
        assertThat(actual).isEqualTo(mockResponse);
    }

    @Test
    void givenInvalidId_whenFindById_thenThrowException() {
        assertThrows(RuntimeException.class,
                () -> bookService.findById(1L));
    }

    @Test
    void findByAuthor() {
        // given
        Book book1 = new Book();
        book1.setTitle("title1");
        book1.setAuthor("author");
        book1.setPublished(LocalDate.of(2000, 6, 30));

        Book book2 = new Book();
        book2.setTitle("title2");
        book2.setAuthor("author");
        book2.setPublished(LocalDate.of(2001, 6, 30));

        BookResponse mockResponse1 = new BookResponse();
        mockResponse1.setId(1L);
        mockResponse1.setTitle("title2");
        mockResponse1.setAuthor("author2");
        mockResponse1.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse mockResponse2 = new BookResponse();
        mockResponse2.setId(2L);
        mockResponse2.setTitle("title");
        mockResponse2.setAuthor("author");
        mockResponse2.setPublished(LocalDate.of(2001, 6, 30));

        when(bookRepository.findByAuthor(anyString()))
                .thenReturn(List.of(book1, book2));
        when(bookMapper.toDto(anyList()))
                .thenReturn(List.of(mockResponse1, mockResponse2));

        // when
        List<BookResponse> actual = bookService.findByAuthor("author");

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void givenBook_whenUpdate_thenReturnUpdatedBook() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublished(LocalDate.of(2000, 6, 30));

        Optional<Book> mockBook = Optional.of(book);

        BookResponse mockResponse = new BookResponse();
        mockResponse.setId(1L);
        mockResponse.setTitle("title2");
        mockResponse.setAuthor("author2");
        mockResponse.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findById(anyLong()))
                .thenReturn(mockBook);
        when(bookMapper.toEntity(any(Book.class), any(BookRequest.class)))
                .thenReturn(book);
        when(bookRepository.save(any(Book.class)))
                .thenReturn(book);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(mockResponse);

        BookRequest updateRequest = new BookRequest();
        updateRequest.setTitle("title2");
        updateRequest.setAuthor("author2");
        updateRequest.setPublished(LocalDate.of(2001, 6, 30));

        // when
        BookResponse actual = bookService.update(1L, updateRequest);

        // then
        assertThat(actual.getTitle()).isEqualTo(updateRequest.getTitle());
    }

    // test void method
    @Test
    void givenBook_whenDelete_thenDbIsEmpty() {
        // given
        doNothing()
                .when(bookRepository).deleteById(anyLong());

        // when
        bookService.delete(1L);

        // then
        // verify the mocked object being called
        verify(bookRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(bookRepository);
    }

    // define test scenario
    // identify what needs to be mocked
    // objects with methods that are being called

    // given
    // mock objects
    // mock return objects

    // when
    // call method under test

    // then
    // assert
}