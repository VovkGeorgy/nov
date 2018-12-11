package main.java.by.home.nov2.utils;

import main.java.by.home.nov2.service.IConsoleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

/**
 * Class with console utils methods
 */
public class ConsoleUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleUtils.class);
    private static String inputLine = "";
    private static int inputInt = 0;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Method get line from console
     *
     * @param method - method which must call in the case of error
     * @return - readed line
     */
    public static String getLineFromConsole(IConsoleHandler method) {
        LOGGER.debug("Get line from console");
        try {
            inputLine = reader.readLine();
            if (inputLine.trim().equals("")) throw new InputMismatchException();
        } catch (IOException | RuntimeException ex) {
            System.out.println("Bad input, try again. Error - " + ex.getMessage());
            LOGGER.error("Bad input in console {}", inputLine, ex.getMessage());
            method.processRequest();
        }
        return inputLine;
    }

    /**
     * Method get int number from console
     *
     * @param method - method which must call in the case of error
     * @return - int number from console
     */
    public static int getIntFromConsole(IConsoleHandler method) {
        LOGGER.debug("Get int number from console");
        try {
            inputInt = Integer.parseInt(reader.readLine());
        } catch (InputMismatchException | IOException ex) {
            System.out.println("Bad input, try again");
            LOGGER.error("bad input in console {}", inputInt);
            method.processRequest();
        }
        return inputInt;
    }
}
