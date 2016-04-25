package nl.mawoo.wcmscript.logger;

/**
 * This interface defines the methods for the logger implementations
 */
public interface logger {
    void error(String message);

    void error(String message, Throwable cause);

    void info(String message);

    void info(String message, Throwable cause);

    void warning(String message);

    void warning(String message, Throwable cause);

}
