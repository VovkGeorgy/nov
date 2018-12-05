package main.java.by.home.nov2.entity;

import main.java.by.home.nov2.entity.impl.IText;
import main.java.by.home.nov2.service.ConsoleHandler;
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

    private static List<String> textList = new ArrayList<>();

    private static Text textInstance;

    private static ConsoleHandler consoleHandlerInstance = ConsoleHandler.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger(Text.class);
    public static Text getInstance() {
        if (textInstance == null) textInstance = new Text();
        return textInstance;
    }
    private static List<String> getTextList() {
        return textList;
    }

    private static void setTextList(List<String> textList) {
        Text.textList = textList;
    }

    @Override
    public void addText() {
        System.out.println("Write Line:");
        textList.addAll(TextParser.parsLine(ConsoleUtils.getLineFromConsole(textInstance::addText)));
    }

    @Override
    public void readFromFile() {
        TextParser.parsFile(Reader.readFile(consoleHandlerInstance::processFirstRequest, getTextFileName()), getTextList());
    }

    @Override
    public void writeInFile() {
        Writer.writeFile(getTextList(), getTextFileName());
    }

    @Override
    public void writeInConsole() {
        getTextList().forEach(System.out::println);
    }

    @Override
    public void addCats() {
        setTextList(TextParser.addCatInText(textList));
    }

    @Override
    public String getTextFileName() {
        System.out.println("Write file name");
        return ConsoleUtils.getLineFromConsole(consoleHandlerInstance::processFirstRequest);
    }
}
