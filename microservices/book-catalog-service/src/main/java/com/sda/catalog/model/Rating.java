package com.sda.catalog.model;

public class Rating {

    private String bookId;
    private int bookRating;

    public Rating() {
    }

    public Rating(String bookId, int bookRating) {
        this.bookId = bookId;
        this.bookRating = bookRating;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }
}
