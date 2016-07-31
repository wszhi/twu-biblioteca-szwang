package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome To Biblioteca!");
        System.out.println("Please chose the menu:print 1 to see bookList");
        Scanner reader = new Scanner(System.in);
        int menuId = reader.nextInt();
        switch (menuId) {
            case 1:
                new ShowBookList().showBookList();
                break;
            default:
                break;
        }

    }
}
