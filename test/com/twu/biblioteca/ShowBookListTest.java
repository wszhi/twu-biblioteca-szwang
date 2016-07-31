package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ShowBookListTest {
    BookAction showBookList;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        showBookList = new BookAction();
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

        showBookList.showBookList(showBookList.getBookInfoList());
        String bookName = "Think in Java";
        assertTrue(bytes.toString().contains(bookName));
    }

    @Test
    public void shouldPrintAuthorAndPublishDateOfBook() throws Exception {
        showBookList.showBookList(showBookList.getBookInfoList());
        String author = "Bruce Eckel";
        String date = "2010-02-01";
        assertTrue(bytes.toString().contains(author));
        assertTrue(bytes.toString().contains(date));

    }
}