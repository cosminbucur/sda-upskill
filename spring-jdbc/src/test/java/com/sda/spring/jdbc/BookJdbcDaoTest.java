package com.sda.spring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class BookJdbcDaoTest {

    @Autowired
    BookJdbcDao bookJdbcDao;

    @Test
    void create() {
        Book book = new Book();
        book.setTitle("test");
        book.setAuthor("test");
        book.setPublishDate(LocalDate.now());
        Book actual = bookJdbcDao.create(book);

        assertThat(actual).isNotNull();
    }
}