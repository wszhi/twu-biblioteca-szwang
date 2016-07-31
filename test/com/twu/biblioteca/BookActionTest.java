package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookActionTest {
    BookAction bookAction;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        bookAction = new BookAction();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void shouldReturnBookListWhenCreateEntity() throws Exception {
        List<BookInfo> bookInfoList = new ArrayList<>();
        bookInfoList.add(new BookInfo(1, "Book1", "Author1", "2010-02-01"));
        bookAction.showBookList(bookInfoList);
        assertTrue(bytes.toString().contains("Book1"));
    }

    @Test
    public void shouldPrintAuthorAndPublishDateOfBook() throws Exception {
        List<BookInfo> bookInfoList = new ArrayList<>();
        bookInfoList.add(new BookInfo(1, "Book1", "Author1", "2010-02-01"));
        bookAction.showBookList(bookInfoList);
        assertTrue(bytes.toString().contains("Author1"));
        assertTrue(bytes.toString().contains("2010-02-01"));
    }

    @Test
    public void shouldShowSuccessMessageWhenBookIsValid() throws Exception {
        BookInfo book = new BookInfo(1, "Think in Java", "Bruce Eckel", "2010-02-01");
        bookAction.checkOutABook("1");
        assertFalse(bookAction.getBookInfoList().contains(book));
        assertTrue(bytes.toString().contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldShowFailMessageWhenBookIsInvalid() throws Exception {
        BookInfo book = new BookInfo(7, "Book7", "Author7", "2010-02-01");
        bookAction.checkOutABook("7");
        assertThat(bookAction.getBookInfoList().size(),is(6));
        assertTrue(bytes.toString().contains("That book is not available."));
    }
}