package main.java.by.home.nov2.entity;

/**
 * Class represents main menu for console output
 */
public class MainMenu {

    private static final int INPUT_TEXT = 1;
    private static final int READ_FILE = 2;
    private static final int EXIT_M1 = 3;
    private static final int CONTINUE_TEXT_INPUT = 1;
    private static final int WRITE_FILE = 2;
    private static final int WRITE_IN_CONSOLE = 3;
    private static final int ADD_CATS = 4;
    private static final int EXIT_M2 = 5;

    /**
     * Show to user Main menu
     * @return - complete first menu in StringBuilder
     */
    public static StringBuilder getMainMenu() {
        StringBuilder stringBuilder1 = new StringBuilder("Choice: \n");
        stringBuilder1.append(INPUT_TEXT).append(".Input text \n");
        stringBuilder1.append(READ_FILE).append(".Read file \n");
        stringBuilder1.append(EXIT_M1).append(".Exit \n");
        return stringBuilder1;
    }

    /**
     * Show to user Additional menu
     * @return - complete second menu in StringBuilder
     */
    public static StringBuilder getAdditionalMenu() {
        StringBuilder stringBuilder2 = new StringBuilder("Choice: \n");
        stringBuilder2.append(CONTINUE_TEXT_INPUT).append(".Continue text input \n");
        stringBuilder2.append(WRITE_FILE).append(".Write file \n");
        stringBuilder2.append(WRITE_IN_CONSOLE).append(".Write in console \n");
        stringBuilder2.append(ADD_CATS).append(".Add cats \n");
        stringBuilder2.append(EXIT_M2).append(".Exit \n");
        return stringBuilder2;
    }

}
