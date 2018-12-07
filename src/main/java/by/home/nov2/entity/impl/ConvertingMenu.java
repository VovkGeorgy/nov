package main.java.by.home.nov2.entity.impl;

import main.java.by.home.nov2.entity.IMenu;

/**
 * Class represents converting menu for console output
 */
public class ConvertingMenu implements IMenu {
    private static final int CONTINUE_TEXT_INPUT = 1;
    private static final int WRITE_FILE = 2;
    private static final int PRINT_IN_CONSOLE = 3;
    private static final int ADD_CATS = 4;
    private static final int EXIT = 5;
    private static ConvertingMenu convertingMenuInstance;

    public static ConvertingMenu getInstance() {
        if (convertingMenuInstance == null) convertingMenuInstance = new ConvertingMenu();
        return convertingMenuInstance;
    }

    @Override
    public StringBuilder getMenu() {
        StringBuilder conversionMenu = new StringBuilder("Choice: \n");
        conversionMenu.append(CONTINUE_TEXT_INPUT).append(".Continue text input \n");
        conversionMenu.append(WRITE_FILE).append(".Write file \n");
        conversionMenu.append(PRINT_IN_CONSOLE).append(".Print in console \n");
        conversionMenu.append(ADD_CATS).append(".Add cats \n");
        conversionMenu.append(EXIT).append(".Exit \n");
        return conversionMenu;
    }
}
