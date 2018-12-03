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
public class PropertyUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtils.class);
    private static Properties appProps = new Properties();
    public static Map<String, String> props = new HashMap<>();

    static {
        LOGGER.debug("Initialise properties");
        try {
            appProps.load(new FileInputStream(Writer.class.getResource("/app.properties").getFile()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        props.put("words.splitter",appProps.getProperty("words.splitter"));
        props.put("text.separator",appProps.getProperty("text.separator"));
        props.put("cat",appProps.getProperty("cat.backup"));
        props.put("words.InLine",appProps.getProperty("words.InLine"));
        LOGGER.debug("Property init is success");
    }

}
