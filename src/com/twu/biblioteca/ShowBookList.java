package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import com.twu.biblioteca.entity.Constants;

import java.util.ArrayList;
import java.util.List;

public class ShowBookList {
    private List<BookInfo> bookInfoList = new ArrayList<>();

    public ShowBookList() {
        this.bookInfoList.add(new BookInfo(1, "Think in Java", "2010-02-01"));
        this.bookInfoList.add(new BookInfo(2, "book1", "2011-02-01"));
        this.bookInfoList.add(new BookInfo(3, "book2", "2012-04-01"));
        this.bookInfoList.add(new BookInfo(4, "book3", "2013-06-01"));
        this.bookInfoList.add(new BookInfo(5, "book5", "2014-04-01"));
        this.bookInfoList.add(new BookInfo(6, "book6", "2016-02-01"));
    }

    public void showBookList() {
        drawLine();
        System.out.println(formatString(Constants.ID)+ formatString(Constants.BOOKNAME)+ formatString(Constants.BOOKPUBDATE));
        drawLine();
        for (BookInfo book : bookInfoList) {
            System.out.println(formatString(String.valueOf(book.getBookId()))+ formatString(book.getBookName()) + formatString(book.getBookPublishDate()));
        }
    }

    private String formatString(String str){
        return String.format("%-30s", str);
    }

    private void drawLine(){
        System.out.println("------------------------------------------------------------------------------------");
    }
}
