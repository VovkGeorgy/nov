package main.java.by.home.nov2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static main.java.by.home.nov2.utils.PropertiesUtils.FILE_IN_PATH;
import static main.java.by.home.nov2.utils.PropertiesUtils.FILE_OUT_PATH;

/**
 * Class with file utilities
 */
public class FilesUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleUtils.class);

    /**
     * Method get file path from property
     *
     * @param fileName - file name to add in path
     * @return - the whole path to named file
     */
    public static String getInputFilePath(String fileName) {
        LOGGER.debug("Get path from named file {}", fileName);
        return PropertiesUtils.props.get(FILE_IN_PATH) + fileName + ".txt";
    }

    /**
     * Get out file path from property
     *
     * @param fileName - users name of text file
     * @return - out file path
     */
    public static String getOutputFilePath(String fileName) {
        LOGGER.debug("Get file {} name from property", fileName);
        return PropertiesUtils.props.get(FILE_OUT_PATH) + fileName + ".txt";
    }
}
