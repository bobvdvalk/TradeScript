package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

/**
 * This class is responsible to log to the console with Log4J
 *
 * @author Bob van der Valk
 */
public class ConsoleLogger implements LoggerInterface {

    private Logger logger;

    public ConsoleLogger(Class clazz) {
        logger = Logger.getLogger(clazz.getClass().getName());
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

    @Override
    public void warning(String message, Throwable cause) {
        logger.warn(message, cause);
    }
}
