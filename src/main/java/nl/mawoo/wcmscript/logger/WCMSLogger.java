package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.Properties;

/**
 * This class is repsonsible to log items to the console or to the web.
 * In the case the WCMScript is connected to a "manager". The info messages, errors and warnings are stored in a
 * mysql database. This is because on the "manager" there is a console reader what shows the output to the front-end.
 * If WCMScript is not connected to a "manager" the logger just normally outputs to the console as a standard application
 * will.
 *
 * @author Bob van der Valk
 */
public class WCMSLogger {

    private WCMSLogger() {

    }

    public static AbstractLogger getLogger(Class clazz) {

        File f = new File("config.properties");
//        Properties prop = WCMSProperties.get();
//
//        if(prop.getProperty("web").equals("true")) {
//            return new WebLogger(prop.getProperty("session_id"));
//        } else {
            return new ConsoleLogger();
//        }
    }

}
