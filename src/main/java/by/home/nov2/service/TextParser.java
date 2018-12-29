package main.java.by.home.nov2.service;

import main.java.by.home.nov2.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static main.java.by.home.nov2.utils.PropertiesUtils.*;

/**
 * Class parse line or file to List of words, and add cats to text
 */
public class TextParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextParser.class);
    private static TextParser textParserInstance;

    /**
     * Method get instance of TextParser class, if null method create it
     *
     * @return - text Parser Instance
     */
    public static TextParser getInstance() {
        if (textParserInstance == null) textParserInstance = new TextParser();
        return textParserInstance;
    }

    /**
     * Method parse line from console
     *
     * @param line - input line
     * @return - List of parsed words
     */
    public List<String> parsLine(String line) {
        LOGGER.debug("parse line from console");
        return Arrays.asList(line.split(PropertiesUtils.props.get(WORDS_SPLITTER)));
    }

    /**
     * Method parse file from system
     *
     * @param listOfFileLines - List of file lines
     * @param listOfWords     - list of words in which it parse
     */
    public void parsFile(List<String> listOfFileLines, List<String> listOfWords) {
        LOGGER.debug("parse file from system");
        listOfFileLines.forEach(line -> listOfWords.addAll(Arrays.asList(line.split(PropertiesUtils.props.get(TEXT_SEPARATOR)))));
    }

    /**
     * Method add cats to text in format "word_cat"
     *
     * @param listOfWords = list of words
     * @return - changed text with cats
     */
    public List<String> addCatInText(List<String> listOfWords) {
        LOGGER.debug("Add cats to text");
        final String catWord = PropertiesUtils.props.get(CAT);
        return listOfWords.stream().distinct().map((word) -> String.join("_", word, catWord)).collect(Collectors.toList());
    }
}
