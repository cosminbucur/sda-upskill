package com.sda.spring.boot.rest.server.dto;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class BookRequest {

    private String title;
    private String author;
    @PastOrPresent
    private LocalDate published;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published='" + published + '\'' +
                '}';
    }
}
