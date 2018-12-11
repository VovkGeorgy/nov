package main.java.by.home.nov2.service;

import main.java.by.home.nov2.utils.FilesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class just have a method which read file from file system
 */
public class Reader {
    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);
    private static Reader readerInstance;

    /**
     * Method get instance of class, if null method create it
     *
     * @return - instance
     */
    public static Reader getInstance() {
        if (readerInstance == null) readerInstance = new Reader();
        return readerInstance;
    }

    /**
     * Method read file from file system
     *
     * @param method   - method which must call in the case of error
     * @param fileName - name of file
     * @return - List of lines from readed file
     */
    public List<String> readFile(IConsoleHandler method, String fileName) {
        String filePath = FilesUtils.getInputFilePath(fileName);
        LOGGER.debug("Reading file from path {}", filePath);
        try {
            return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (NullPointerException e) {
            LOGGER.error("File {} does not exist", filePath);
            method.processRequest();
        } catch (IOException e) {
            LOGGER.error("Cant read file {}", filePath);
            method.processRequest();
        }
        LOGGER.debug("File successfully readed {}", filePath);
        System.out.println("File successfully read!");
        return null;
    }
}
