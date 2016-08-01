package com.twu.biblioteca;

import com.twu.biblioteca.entity.Users;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserActionTest {

    UserAction userAction;

    @Before
    public void setUp() throws Exception {
        userAction = new UserAction();
    }

    @Test
    public void shouldReturnTrueWhenLibraryNumberAndPasswordIsCorrect() throws Exception {
        Users users = new Users("000-0001", "123456", "librarian", "Lily", "lily@gmail.com", "China", "13411200926");
        assertTrue(userAction.loginAction(users.getLibraryNumber(), users.getPassword()));
    }

    @Test
    public void shouldReturnFalseWhenLibraryNumberAndPasswordIsNotCorrect() throws Exception {
        Users users = new Users("000-0002", "123456", "librarian", "Lily", "lily@gmail.com", "China", "13411200926");
        assertFalse(userAction.loginAction(users.getLibraryNumber(), users.getPassword()));
    }
}