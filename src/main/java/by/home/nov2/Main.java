package main.java.by.home.nov2;

import main.java.by.home.nov2.service.impl.ConsoleHandler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleHandler consoleHandler = ConsoleHandler.getInstance();
        consoleHandler.processMainMenuRequest();
    }
}
