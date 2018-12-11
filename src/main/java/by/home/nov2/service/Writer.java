package main.java.by.home.nov2.service;

import main.java.by.home.nov2.utils.FilesUtils;
import main.java.by.home.nov2.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static main.java.by.home.nov2.utils.PropertiesUtils.TEXT_SEPARATOR;
import static main.java.by.home.nov2.utils.PropertiesUtils.WORDS_IN_LINE;

/**
 * This class only write file
 */
public class Writer {
    private int skipVar = 0;
    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);
    private static Writer writerInstance;

    /**
     * Method get instance of class, if null method create it
     *
     * @return - instance
     */
    public static Writer getInstance() {
        if (writerInstance == null) writerInstance = new Writer();
        return writerInstance;
    }

    /**
     * Method get list of words from console or file, and write them in other file
     *
     * @param listOfWords - collection of words
     * @param fileName    - name of new file
     */
    public void writeFile(List<String> listOfWords, String fileName) {
        String outFilePath = FilesUtils.getOutputFilePath(fileName);
        try (FileWriter writer = new FileWriter(outFilePath, true)) {
            LOGGER.debug("Start writing file to path {}", outFilePath);
            writeWords(listOfWords, writer);
            System.out.println("File successfully writed!");
        } catch (IOException ex) {
            LOGGER.error("File not write {}", outFilePath);
        }
        LOGGER.debug("File {} successfully writed!", outFilePath);
    }

    /**
     * Method write words in file
     *
     * @param listOfWords - collection of words
     * @param writer      - instance of FileWriter
     * @throws IOException - Exception of incorrect output
     */
    private void writeWords(List<String> listOfWords, FileWriter writer) throws IOException {
        final int wordsLimit = Integer.parseInt(PropertiesUtils.props.get(WORDS_IN_LINE));
        final String delimiter = PropertiesUtils.props.get(TEXT_SEPARATOR);
        for (String word : listOfWords) {
            if (skipVar < wordsLimit) {
                writer.write(word);
                writer.append(delimiter);
                skipVar++;
            } else {
                writer.append("\n");
                skipVar = 0;
            }
        }
    }
}