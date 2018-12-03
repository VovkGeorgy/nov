package main.java.by.home.nov2.service;

import main.java.by.home.nov2.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class only write file
 */
public class Writer {
    private static int skipVar = 0;
    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);

    /**
     * Method get list of words from console or file, and write them in other file
     *
     * @param listOfWords - collection of word
     * @param fileName    - name of new file
     */
    public static void writeFile(List<String> listOfWords, String fileName) {
        String outFilePath = ClassLoader.class.getResource("/main/resources/") + fileName + ".txt";
        outFilePath = outFilePath.substring(6);
        LOGGER.debug("Start writing file to path" + outFilePath);
        try (FileWriter writer = new FileWriter(outFilePath, true)) {
            for (String word : listOfWords) {
                if (skipVar < Integer.parseInt(PropertyUtils.props.get("words.InLine"))) {
                    writer.write(word);
                    writer.append(PropertyUtils.props.get("text.separator"));
                    skipVar++;
                } else {
                    writer.append("\n");
                    skipVar = 0;
                }
            }
            System.out.println("File successfully created!");
        } catch (IOException ex) {
            LOGGER.error("File not write" + ex.getMessage());
        }
    }
}