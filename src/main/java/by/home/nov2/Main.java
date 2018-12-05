package main.java.by.home.nov2;

import main.java.by.home.nov2.service.impl.ConsoleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.debug("Main class start");
        ConsoleHandler consoleHandler = ConsoleHandler.getInstance();
        consoleHandler.processFirstRequest();
    }
}
