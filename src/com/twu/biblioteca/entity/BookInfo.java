package com.twu.biblioteca.entity;

public class BookInfo {

    private long bookId;

    private String bookName;

    private String author;

    private String bookPublishDate;

    public BookInfo(long bookId, String bookName, String author, String bookPublishDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookPublishDate = bookPublishDate;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(String bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }
}
