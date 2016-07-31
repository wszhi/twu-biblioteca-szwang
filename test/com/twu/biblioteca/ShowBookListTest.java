package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ShowBookListTest {
    ShowBookList showBookList;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        showBookList=new ShowBookList();
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
        showBookList.showBookList();
        String bookName="Think in Java";
        assertTrue(bytes.toString().contains(bookName));
    }
}