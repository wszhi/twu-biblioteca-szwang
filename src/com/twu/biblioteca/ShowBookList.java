package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import com.twu.biblioteca.entity.Constants;

import java.util.ArrayList;
import java.util.List;

public class ShowBookList {
    private List<BookInfo> bookInfoList = new ArrayList<>();

    public ShowBookList() {
        this.bookInfoList.add(new BookInfo(1, "Think in Java", "Bruce Eckel", "2010-02-01"));
        this.bookInfoList.add(new BookInfo(2, "The Kite Runner", "haled Hosseini", "2004-02-01"));
        this.bookInfoList.add(new BookInfo(3, "The History Of Love", "Nicole Krauss", "2005-04-01"));
        this.bookInfoList.add(new BookInfo(4, "The Da Vinci Code", "Dan Brown", "2006-06-01"));
        this.bookInfoList.add(new BookInfo(5, "The Kite Runner. Movie Tie-In", "Khaled Hosseini", "2007-04-01"));
        this.bookInfoList.add(new BookInfo(6, "The Moon and Sixpence", "W. Somerset Maugham", "2016-02-01"));
    }

    public void showBookList() {
        drawLine();
        System.out.println(formatShortString(Constants.ID) + formatString(Constants.BOOKNAME)
                + formatString(Constants.AUTHOR) + formatString(Constants.BOOKPUBDATE));
        drawLine();
        for (BookInfo book : bookInfoList) {
            System.out.println(formatShortString(String.valueOf(book.getBookId())) + formatString(book.getBookName())
                    + formatString(book.getAuthor()) + formatString(book.getBookPublishDate()));
        }
    }

    private String formatString(String str) {
        return String.format("%-30s", str);
    }

    private String formatShortString(String str) {
        return String.format("%-10s", str);
    }

    private void drawLine() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
