package com.sda.spring.resttemplate.dto;

import java.util.List;

public class BookResponseList {

    private List<BookResponse> bookResponses;

    public List<BookResponse> getBookResponses() {
        return bookResponses;
    }

    public void setBookResponses(List<BookResponse> bookResponses) {
        this.bookResponses = bookResponses;
    }
}
