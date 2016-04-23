package nl.mawoo.wcmscript.logger;

/**
 * This logger appends the Log4J logger.
 * And checks if the application is runed localy or on the websit
 */
public interface WCMSLogger {
    WCMSLogger getLogger(Class clazz);

    void error(String message);

    void error(String message, Throwable cause);

    void info(String message);

    void info(String message, Throwable cause);

    void warning(String message);
}
