package main.java.by.home.nov2.entity.impl;

import main.java.by.home.nov2.entity.IMenu;

/**
 * Class represents main menu for console output
 */
public class MainMenu implements IMenu {
    public static final int INPUT_TEXT = 1;
    public static final int READ_FILE = 2;
    public static final int EXIT = 3;
    private static MainMenu mainMenuInstance;

    public static MainMenu getInstance() {
        if (mainMenuInstance == null) mainMenuInstance = new MainMenu();
        return mainMenuInstance;
    }

    @Override
    public StringBuilder getMenu() {
        StringBuilder mainMenu = new StringBuilder("Choice: \n");
        mainMenu.append(INPUT_TEXT).append(".Input text \n");
        mainMenu.append(READ_FILE).append(".Read file \n");
        mainMenu.append(EXIT).append(".Exit \n");
        return mainMenu;
    }
}
