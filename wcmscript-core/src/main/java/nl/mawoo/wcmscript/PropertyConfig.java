package nl.mawoo.wcmscript;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig implements PropertyInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyConfig.class);

    public Properties load() {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream("config.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            LOGGER.error("Cannot find property file", e);
        } catch (IOException e) {
            LOGGER.error("Something went wrong reading property file", e);
        }
        return properties;
    }
}
