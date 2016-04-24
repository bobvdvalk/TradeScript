package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

/**
 * This class is responsible to log to the WebManager
 * TODO: create stream to web
 * @author Bob van der Valk
 */
public class WebLogger implements WCMSLogger {

    private Logger logger;

    @Override
    public WCMSLogger getLogger(Class clazz) {
        logger = Logger.getLogger(clazz.getName());
        return this;
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Throwable cause) {
        logger.error(message, cause);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Throwable cause) {
        logger.info(message, cause);
    }

    @Override
    public void warning(String message) {
        logger.warn(message);
    }
}
