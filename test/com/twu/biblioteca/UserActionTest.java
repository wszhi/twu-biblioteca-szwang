package com.twu.biblioteca;

import com.twu.biblioteca.entity.Users;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserActionTest {

    UserAction userAction;

    @Before
    public void setUp() throws Exception {
        userAction = new UserAction();
    }

    @Test
    public void shouldReturnTrueWhenLibraryNumberAndPasswordIsCorrect() throws Exception {
        Users users = new Users("000-0001", "123456", "librarian", "Lily", "lily@gmail.com", "China", "13411200926");
        Users usersResult = userAction.loginAction(users.getLibraryNumber(), users.getPassword());
        assertNotNull(usersResult);
        assertThat(usersResult.getLibraryNumber(), is("000-0001"));
    }


    @Test
    public void shouldReturnFalseWhenLibraryNumberAndPasswordIsNotCorrect() throws Exception {
        Users users = new Users("000-0002", "123456", "librarian", "Lily", "lily@gmail.com", "China", "13411200926");
        assertNull(userAction.loginAction(users.getLibraryNumber(), users.getPassword()));
    }
}