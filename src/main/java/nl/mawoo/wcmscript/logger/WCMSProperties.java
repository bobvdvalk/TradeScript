package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * This class is responsible to read and create properties.
 *
 * @author Bob van der Valk
 */
public class WCMSProperties {
    /**
     * Get the properties from a existing file
     * @return current properties
     */
    public static Properties get() {
        Logger logger = Logger.getLogger(WCMSProperties.class.getName());
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);

            return prop;
        } catch (FileNotFoundException e) {
            logger.error("Can\'t load the property file", e);
        } catch (IOException e) {
            logger.error("Can\'t load the properties", e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                logger.error("Can\'t close the property file", e);
            }
        }

        return null;
    }

    /**
     * Create a new properties file.
     * @return current properties
     */
    public static Properties create() {
        Logger logger = Logger.getLogger(WCMSProperties.class.getName());
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("config.properties");

            prop.setProperty("mysql_host", "localhost");
            prop.setProperty("mysql_user", "root");
            prop.setProperty("mysql_pass", "");
            prop.setProperty("mysql_db", "wcmsmanager");
            prop.setProperty("web", "false");

            prop.store(output, null);

            return prop;
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
        return null;
    }
}
