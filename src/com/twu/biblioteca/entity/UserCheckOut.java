package com.twu.biblioteca.entity;

import java.util.List;

public class UserCheckOut {
    private Users users;
    private List<Movie> userMovieList;
    private List<BookInfo> userBookInfoList;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Movie> getUserMovieList() {
        return userMovieList;
    }

    public void setUserMovieList(List<Movie> userMovieList) {
        this.userMovieList = userMovieList;
    }

    public List<BookInfo> getUserBookInfoList() {
        return userBookInfoList;
    }

    public void setUserBookInfoList(List<BookInfo> userBookInfoList) {
        this.userBookInfoList = userBookInfoList;
    }
}
