package main.java.by.home.nov2.entity.impl;

import main.java.by.home.nov2.entity.IText;
import main.java.by.home.nov2.service.impl.ConsoleHandler;
import main.java.by.home.nov2.service.Reader;
import main.java.by.home.nov2.service.TextParser;
import main.java.by.home.nov2.service.Writer;
import main.java.by.home.nov2.utils.ConsoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of text entity it consist of text in List format, and methods to do something with it.
 */
public class Text implements IText {
    private List<String> textList = new ArrayList<>();
    private static Text textInstance;
    private ConsoleHandler consoleHandlerInstance = ConsoleHandler.getInstance();
    private TextParser textParser = TextParser.getInstance();
    private Reader reader = Reader.getInstance();
    private Writer writer = Writer.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger(Text.class);

    public static Text getInstance() {
        if (textInstance == null) textInstance = new Text();
        return textInstance;
    }

    private List<String> getTextList() {
        return textList;
    }

    private void setTextList(List<String> textList) {
        this.textList = textList;
    }

    @Override
    public void addText() {
        System.out.println("Write Line:");
        LOGGER.debug("Add text from console to List");
        textList.addAll(textParser.parsLine(ConsoleUtils.getLineFromConsole(textInstance::addText)));
    }

    @Override
    public void readFromFile() {
        LOGGER.debug("Add text from file to list");
        textParser.parsFile(reader.readFile(consoleHandlerInstance::processMainMenuRequest, getTextFileName()), getTextList());
    }

    @Override
    public void writeInFile() {
        LOGGER.debug("Write text in file");
        writer.writeFile(getTextList(), getTextFileName());
    }

    @Override
    public void printInConsole() {
        LOGGER.debug("Write text in console");
        getTextList().forEach(System.out::println);
    }

    @Override
    public void addCats() {
        LOGGER.debug("Add cats to text");
        setTextList(textParser.addCatInText(textList));
    }

    @Override
    public String getTextFileName() {
        System.out.println("Write file name");
        LOGGER.debug("Get text file name from console");
        return ConsoleUtils.getLineFromConsole(consoleHandlerInstance::processMainMenuRequest);
    }
}
