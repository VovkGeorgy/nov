package main.java.by.home.nov2.utils;

import main.java.by.home.nov2.service.IConsoleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class with console utils methods
 */
public class ConsoleUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleUtils.class);
    private static String inputLine = "";
    private static int inputInt = 0;

    /**
     * Method get line from console
     * @param method - method which must call in the case of error
     * @return - readed line
     */
    public static String getLineFromConsole(IConsoleHandler method) {
        LOGGER.debug("Get line from console");
        Scanner in = new Scanner(System.in);
        try {
            inputLine = in.nextLine();
            if (inputLine.trim().equals("") || inputLine.trim().equals(" ")) throw new InputMismatchException();
        } catch (Exception ex) {
            System.out.println("Bad input, try again");
            LOGGER.error("Bad input in console");
            method.processRequest();
        }
        return inputLine;
    }

    /**
     * Method get int number from console
     * @param method - method which must call in the case of error
     * @return - int number from console
     */
    public static int getIntFromConsole(IConsoleHandler method) {
        LOGGER.debug("Get int number from console");
        Scanner in = new Scanner(System.in);
        try {
            inputInt = in.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Bad input, try again");
            LOGGER.error("bad input in console");
            method.processRequest();
        }
        return inputInt;
    }
}
