package main.java.by.home.nov2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class with file utilities
 */
public class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleUtils.class);

    /**
     * Method get file path from file system
     * @param fileName - file name to add in path
     * @return - the whole path to named file
     */
    public static String getFilePath(String fileName) {
        LOGGER.debug("Get path from named file");
        String filePath = ClassLoader.class.getResource("/main/resources/") + fileName;
        filePath = filePath.substring(6);
        return filePath;
    }
}
