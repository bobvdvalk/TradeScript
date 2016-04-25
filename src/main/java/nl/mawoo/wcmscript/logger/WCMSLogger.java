package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

/**
 * This class is repsonsible to log items to the console or to the web.
 *
 * @author Bob van der Valk
 */
public class WCMSLogger {
    private Logger log4j;

    public WCMSLogger(Class clazz) {
        log4j = Logger.getLogger(clazz.getClass().getName());
    }


}
