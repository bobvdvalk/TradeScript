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
    private Logger log4j;

    private WCMSLogger() {

    }

    public static AbstractLogger getLogger(Class clazz) {
        Logger log4j = Logger.getLogger(clazz.getClass().getName());

        File f = new File("config.properties");

        if(f.exists()) {
            WCMSProperties.get();
        } else {
            WCMSProperties.create();
        }

        return new ConsoleLogger();
    }
}
