package com.twu.biblioteca;

import com.twu.biblioteca.entity.Users;

import java.util.ArrayList;
import java.util.List;

public class UserAction {
    private List<Users> usersList = new ArrayList<>();


    public UserAction() {
        createUsersList();
    }

    private void createUsersList() {
        usersList.add(new Users("000-0001", "123456", "librarian", "Lily", "lily@gmail.com", "China", "13411200926"));
        usersList.add(new Users("001-0011", "123456", "librarian", "Mary", "mary@gmail.com", "China", "13411200926"));
        usersList.add(new Users("011-0111", "123456", "customer", "Lucy", "lucy@gmail.com", "China", "13411200926"));
        usersList.add(new Users("111-1111", "123456", "customer", "Tom", "tom@gmail.com", "China", "13411200926"));
    }

    public Users loginAction(String libraryNumber, String password) {
        for (Users users : usersList) {
            if (users.getLibraryNumber().equals(libraryNumber) && users.getPassword().equals(password)) {
                return users;
            }
        }
        return null;
    }
}
