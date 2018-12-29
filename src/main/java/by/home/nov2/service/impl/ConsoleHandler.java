package main.java.by.home.nov2.service.impl;

import main.java.by.home.nov2.entity.impl.ConvertingMenu;
import main.java.by.home.nov2.entity.impl.MainMenu;
import main.java.by.home.nov2.entity.impl.Text;
import main.java.by.home.nov2.utils.ConsoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class process users requests from console and call needed methods
 */
public class ConsoleHandler {
    private static ConsoleHandler consoleHandlerInstance;
    private static Text textInstance = Text.getInstance();
    private static MainMenu mainMenuInstance = MainMenu.getInstance();
    private static ConvertingMenu convertingMenuInstance = ConvertingMenu.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleHandler.class);

    public static ConsoleHandler getInstance() {
        if (consoleHandlerInstance == null) consoleHandlerInstance = new ConsoleHandler();
        return consoleHandlerInstance;
    }


    /**
     * Method process request from user in Main menu
     */
    public void processMainMenuRequest() {
        LOGGER.debug("Processing Main Menu request");
        System.out.println(mainMenuInstance.getMenu());
        switch (ConsoleUtils.getIntFromConsole(consoleHandlerInstance::processMainMenuRequest)) {
            case MainMenu.INPUT_TEXT:
                textInstance.addText();
                break;
            case MainMenu.READ_FILE:
                textInstance.readFromFile();
                break;
            case MainMenu.EXIT:
                System.exit(111);
                break;
            default:
                System.out.println("Wrong input");
                processMainMenuRequest();
        }
        processConvertingMenuRequest();
    }

    /**
     * Method process requests from user in text conversion menu
     */
    private void processConvertingMenuRequest() {
        LOGGER.debug("Processing Converting Menu request");
        System.out.println(convertingMenuInstance.getMenu());
        switch (ConsoleUtils.getIntFromConsole(consoleHandlerInstance::processConvertingMenuRequest)) {
            case ConvertingMenu.CONTINUE_TEXT_INPUT:
                textInstance.addText();
                break;
            case ConvertingMenu.WRITE_FILE:
                textInstance.writeInFile();
                break;
            case ConvertingMenu.PRINT_IN_CONSOLE:
                textInstance.printInConsole();
                break;
            case ConvertingMenu.ADD_CATS:
                textInstance.addCats();
                break;
            case ConvertingMenu.EXIT:
                System.exit(222);
                break;
            default:
                System.out.println("Wrong input");
                processConvertingMenuRequest();
        }
        processConvertingMenuRequest();
    }
}