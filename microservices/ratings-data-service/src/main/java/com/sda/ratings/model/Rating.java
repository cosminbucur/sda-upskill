package com.sda.ratings.model;

public class Rating {

    private String bookId;
    private int rating;

    public Rating() {
    }

    public Rating(String bookId, int rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
