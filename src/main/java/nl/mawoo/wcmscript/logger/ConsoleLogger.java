package nl.mawoo.wcmscript.logger;

import org.apache.log4j.Logger;

/**
 * This class is responsible to log to the console with Log4J
 *
 * @author Bob van der Valk
 */
public class ConsoleLogger extends AbstractLogger {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    protected void logMessage(MessageType type, String message) {
        switch (type.toString()) {
            case "ERROR":
                logger.error(message);
                break;
            case "INFO":
                logger.info(message);
                break;
            case "WARNING":
                logger.warn(message);
                break;
        }
    }

    @Override
    protected void logMessage(MessageType type, String message, Throwable cause) {
        switch (type.toString()) {
            case "ERROR":
                logger.error(message, cause);
                break;
            case "INFO":
                logger.info(message, cause);
                break;
            case "WARNING":
                logger.warn(message, cause);
                break;
        }
    }
}
