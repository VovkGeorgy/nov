package main.java.by.home.nov2.service.impl;

import main.java.by.home.nov2.entity.MainMenu;
import main.java.by.home.nov2.entity.impl.Text;
import main.java.by.home.nov2.utils.ConsoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class process users requests from console and call needed methods
 */
public class ConsoleHandler {
    private static final int INPUT_TEXT = 1;
    private static final int READ_FILE = 2;
    private static final int EXIT_M1 = 3;
    private static final int CONTINUE_TEXT_INPUT = 1;
    private static final int WRITE_FILE = 2;
    private static final int WRITE_IN_CONSOLE = 3;
    private static final int ADD_CATS = 4;
    private static final int EXIT_M2 = 5;
    private static ConsoleHandler consoleHandlerInstance;
    private static Text textInstance = Text.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleHandler.class);

    public static ConsoleHandler getInstance() {
        if (consoleHandlerInstance == null) consoleHandlerInstance = new ConsoleHandler();
        return consoleHandlerInstance;
    }


    /**
     * Method process first request from user
     */
    public void processFirstRequest() {
        LOGGER.debug("Getting first response");
        System.out.println(MainMenu.getMainMenu());
        switch (ConsoleUtils.getIntFromConsole(consoleHandlerInstance::processFirstRequest)) {
            case INPUT_TEXT:
                textInstance.addText();
                break;
            case READ_FILE:
                textInstance.readFromFile();
                break;
            case EXIT_M1:
                System.exit(111);
                break;
            default:
                System.out.println("Wrong input");
                processFirstRequest();
        }
        processSecondRequest();
    }

    /**
     * Method process subsequent requests from user
     */
    private void processSecondRequest() {
        LOGGER.debug("Getting second response");
        System.out.println(MainMenu.getAdditionalMenu());
        switch (ConsoleUtils.getIntFromConsole(consoleHandlerInstance::processSecondRequest)) {
            case CONTINUE_TEXT_INPUT:
                textInstance.addText();
                break;
            case WRITE_FILE:
                textInstance.writeInFile();
                System.exit(222);
                break;
            case WRITE_IN_CONSOLE:
                textInstance.writeInConsole();
                break;
            case ADD_CATS:
                textInstance.addCats();
                break;
            case EXIT_M2:
                System.exit(222);
                break;
            default:
                System.out.println("Wrong input");
                processSecondRequest();
        }
        processSecondRequest();
    }
}