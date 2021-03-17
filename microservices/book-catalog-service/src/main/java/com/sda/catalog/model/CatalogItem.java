package com.sda.catalog.model;

public class CatalogItem {

    // TODO: add userId
    // TODO: add name
    private String bookId;
    private String title;
    private String author;
    private int rating;

    public CatalogItem() {
    }

    public CatalogItem(String bookId, String title, String author, int rating) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
