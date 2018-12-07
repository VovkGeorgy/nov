package main.java.by.home.nov2.utils;

import main.java.by.home.nov2.service.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class get file properties from system and add fields of it to HashMap
 */
public class PropertiesUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);
    private static Properties appProps = new Properties();
    public static Map<String, String> props = new HashMap<>();

    private static final String WORDS_SPLITTER = "words.splitter";
    private static final String TEXT_SEPARATOR = "text.separator";
    private static final String CAT = "cat";
    private static final String WORDS_IN_LINE = "words.in.line.limit";
    private static final String FILE_OUT_PATH = "file.out.path";
    private static final String FILE_IN_PATH = "file.in.path";

    static {
        LOGGER.debug("Initialise properties");
        try {
            appProps.load(new FileInputStream(Writer.class.getResource("/app.properties").getFile()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        props.put(WORDS_SPLITTER, appProps.getProperty("words.splitter"));
        props.put(TEXT_SEPARATOR, appProps.getProperty("text.separator"));
        props.put(WORDS_IN_LINE, appProps.getProperty("words.in.line.limit"));
        props.put(FILE_OUT_PATH, appProps.getProperty("file.out.path"));
        props.put(FILE_IN_PATH, appProps.getProperty("file.in.path"));
        props.put(CAT, appProps.getProperty("cat"));
        LOGGER.debug("Property init is success");
    }

}
