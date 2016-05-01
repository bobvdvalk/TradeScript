package nl.mawoo.wcmscript.logger;

/**
 * Log the messages to the console or to the WCMScript manager
 *
 * @author Bob van der Valk
 */
abstract class AbstractLogger implements LoggerInterface {
    /**
     * Log a error
     * @param message string of the message
     */
    @Override
    public void error(String message) {
        this.logMessage(MessageType.ERROR, message);
    }

    /**
     * Log a error
     * @param message string of the message
     * @param cause throwable
     */
    @Override
    public void error(String message, Throwable cause) {
        this.logMessage(MessageType.ERROR, message, cause);
    }

    /**
     * Log a info message
     * @param message string of the message
     */
    @Override
    public void info(String message) {
        this.logMessage(MessageType.INFO, message);
    }

    /**
     * Log a info message
     * @param message string of the message
     * @param cause throwable
     */
    @Override
    public void info(String message, Throwable cause) {
        this.logMessage(MessageType.INFO, message, cause);
    }

    /**
     * Log a warning message
     * @param message string of the message
     */
    @Override
    public void warning(String message) {
        this.logMessage(MessageType.WARNING, message);
    }

    /**
     * Log a warning message
     * @param message string of the message
     * @param cause throwable
     */
    @Override
    public void warning(String message, Throwable cause) {
        this.logMessage(MessageType.WARNING, message, cause);
    }

    /**
     * Send a message to the current logger.
     * @param type enum of the message type
     * @param message string of the message
     */
    protected abstract void logMessage(MessageType type, String message);

    /**
     * Send a message to the current logger.
     * @param type enum of the message type
     * @param message string of the message
     * @param cause throwable error.
     */
    protected abstract void logMessage(MessageType type, String message, Throwable cause);
}
