package main.java.by.home.nov2.service;

import main.java.by.home.nov2.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class pars line or file to List of words, and add cats to text
 */
public class TextParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtils.class);

    /**
     * Method pars line from console
     * @param line - input line
     * @return - List of parsed words
     */
    public static List<String> parsLine(String line) {
        LOGGER.debug("Pars line from console");
        return Arrays.asList(line.split(PropertyUtils.props.get("words.splitter")));
    }

    /**
     * Method pars file from system
     * @param listOfFileLines - List of file lines
     * @param listOfWords - list of words in which it pars
     */
    public static void parsFile(List<String> listOfFileLines, List<String> listOfWords) {
        LOGGER.debug("Pars file from system");
        listOfFileLines.forEach(line -> listOfWords.addAll(Arrays.asList(line.split(PropertyUtils.props.get("text.separator")))));
    }

    /**
     * Method add cats to text in format "word_cat"
     * @param listOfWords = list of words
     * @return - changed text with cats
     */
    public static List<String> addCatInText(List<String> listOfWords) {
        LOGGER.debug("Add cats to text");
        return listOfWords.stream().distinct().map((e) -> e + "_" + PropertyUtils.props.get("cat")).collect(Collectors.toList());
    }

}
