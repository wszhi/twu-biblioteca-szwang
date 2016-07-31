package com.twu.biblioteca.entity;

public class Options {

    private int menuID;

    private String menuName;

    public Options() {
    }

    public Options(int menuID, String menuName) {
        this.menuID = menuID;
        this.menuName = menuName;
    }

    public int getMenuID() {
        return menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void createMenu() {
        Options options = new Options(1, Constants.LISTBOOKS);
        System.out.println("---------------------");
        System.out.println("| " + options.getMenuName() + "(" + options.getMenuID() + ")" + " |");
        System.out.println("---------------------");
    }
}
