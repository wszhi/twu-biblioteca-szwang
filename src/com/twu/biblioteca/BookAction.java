package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import com.twu.biblioteca.entity.Constants;

import java.util.ArrayList;
import java.util.List;

public class BookAction {
    private List<BookInfo> bookInfoList = new ArrayList<>();
    private List<BookInfo> checkOutBooks = new ArrayList<>();
    FormatPrint formatPrint = new FormatPrint();

    public BookAction() {
        this.bookInfoList.add(new BookInfo(1, "Think in Java", "Bruce Eckel", "2010-02-01"));
        this.bookInfoList.add(new BookInfo(2, "The Kite Runner", "haled Hosseini", "2004-02-01"));
        this.bookInfoList.add(new BookInfo(3, "The History Of Love", "Nicole Krauss", "2005-04-01"));
        this.bookInfoList.add(new BookInfo(4, "The Da Vinci Code", "Dan Brown", "2006-06-01"));
        this.bookInfoList.add(new BookInfo(5, "The Kite Runner. Movie Tie-In", "Khaled Hosseini", "2007-04-01"));
        this.bookInfoList.add(new BookInfo(6, "The Moon and Sixpence", "W. Somerset Maugham", "2016-02-01"));
    }

    public List<BookInfo> getBookInfoList() {
        return bookInfoList;
    }

    public List<BookInfo> getCheckOutBooks() {
        return checkOutBooks;
    }

    public void showBookList(List<BookInfo> booksList) {
        formatPrint.drawLine();
        System.out.println(formatPrint.formatShortString(Constants.ID)
                + formatPrint.formatString(Constants.BOOKNAME)
                + formatPrint.formatString(Constants.AUTHOR)
                + formatPrint.formatString(Constants.BOOKPUBDATE));
        formatPrint.drawLine();
        for (BookInfo book : booksList) {
            System.out.println(formatPrint.formatShortString(String.valueOf(book.getBookId()))
                    + formatPrint.formatString(book.getBookName())
                    + formatPrint.formatString(book.getAuthor())
                    + formatPrint.formatString(book.getBookPublishDate()));
        }
        formatPrint.drawLine();
    }

    public BookInfo checkOutABook(String bookId) {
        BookInfo exitsBook = null;
        for (BookInfo book : bookInfoList) {
            if (String.valueOf(book.getBookId()).equals(bookId)) {
                bookInfoList.remove(book);
                checkOutBooks.add(book);
                exitsBook = book;
                break;
            }
        }
        if (exitsBook != null) {
            System.out.println(Constants.CHECKOUTSUCCESSMSG);
        } else {
            System.out.println(Constants.CHECKOUTFAILMSG);
        }
        return exitsBook;
    }

    public BookInfo returnBook(String bookId) {
        BookInfo validReturnBook = null;
        for (BookInfo book : checkOutBooks) {
            if (String.valueOf(book.getBookId()).equals(bookId)) {
                bookInfoList.add(book);
                checkOutBooks.remove(book);
                validReturnBook = book;
                break;
            }
        }
        if (validReturnBook != null) {
            System.out.println(Constants.RETURNBOOKSUCCESS);
        } else {
            System.out.println(Constants.RETURNBOOKFAIL);
        }
        return validReturnBook;
    }
}
