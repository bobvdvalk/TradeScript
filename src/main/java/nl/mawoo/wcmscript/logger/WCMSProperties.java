package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class WCMSProperties {
    private static Logger logger = Logger.getLogger(WCMSProperties.class.getName());

    public void create() {
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
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}
