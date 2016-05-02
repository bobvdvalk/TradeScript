package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.Properties;

/**
 * This class is repsonsible to log items to the console or to the web.
 *
 * @author Bob van der Valk
 */
public class WCMSLogger {

    private WCMSLogger() {

    }

    public static AbstractLogger getLogger(Class clazz) {

        File f = new File("config.properties");
        Properties prop = WCMSProperties.get();

        if(prop.getProperty("web").equals("true")) {
            return new WebLogger(prop.getProperty("session_id"));
        } else {
            return new ConsoleLogger();
        }
    }

}
