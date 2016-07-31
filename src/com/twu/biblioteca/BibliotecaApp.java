package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import com.twu.biblioteca.entity.Constants;
import com.twu.biblioteca.entity.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookAction bookAction = new BookAction();
        List<BookInfo> bookInfoList = bookAction.getBookInfoList();
        System.out.println(Constants.WELCOME);
        System.out.println(Constants.TIPS);
        createMenu();
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "1":
                    bookAction.showBookList(bookInfoList);
                    break;
                case "2":
                    System.out.print(Constants.CHECKOUTTIPS);
                    bookAction.checkOutABook(reader.next());
                    break;
                case "9":
                    return;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }

    }

    public static void createMenu() {
        List<Options> optionsList = new ArrayList<>();
        optionsList.add(new Options(1, Constants.LISTBOOKS));
        optionsList.add(new Options(2, Constants.CHECKOUTBOOKS));
        optionsList.add(new Options(9, Constants.QUIT));
        new Options().createMenu(optionsList);
    }

}
