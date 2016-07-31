package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import com.twu.biblioteca.entity.Constants;

import java.util.ArrayList;
import java.util.List;

public class ShowBookList {
    private List<BookInfo> bookInfoList = new ArrayList<>();
    FormatPrint formatPrint=new FormatPrint();

    public ShowBookList() {
        this.bookInfoList.add(new BookInfo(1, "Think in Java", "Bruce Eckel", "2010-02-01"));
        this.bookInfoList.add(new BookInfo(2, "The Kite Runner", "haled Hosseini", "2004-02-01"));
        this.bookInfoList.add(new BookInfo(3, "The History Of Love", "Nicole Krauss", "2005-04-01"));
        this.bookInfoList.add(new BookInfo(4, "The Da Vinci Code", "Dan Brown", "2006-06-01"));
        this.bookInfoList.add(new BookInfo(5, "The Kite Runner. Movie Tie-In", "Khaled Hosseini", "2007-04-01"));
        this.bookInfoList.add(new BookInfo(6, "The Moon and Sixpence", "W. Somerset Maugham", "2016-02-01"));
    }

    public void showBookList() {
        formatPrint.drawLine();
        System.out.println(formatPrint.formatShortString(Constants.ID)
                + formatPrint.formatString(Constants.BOOKNAME)
                + formatPrint.formatString(Constants.AUTHOR)
                + formatPrint.formatString(Constants.BOOKPUBDATE));
        formatPrint.drawLine();
        for (BookInfo book : bookInfoList) {
            System.out.println(formatPrint.formatShortString(String.valueOf(book.getBookId()))
                    + formatPrint.formatString(book.getBookName())
                    + formatPrint.formatString(book.getAuthor())
                    + formatPrint.formatString(book.getBookPublishDate()));
        }
        formatPrint.drawLine();
    }
}
