package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 3-3-2016.
 */
public class WCMScriptException extends RuntimeException {
    public WCMScriptException(String message) {
        super(message);
    }

    public WCMScriptException(String message, Throwable cause) {
        super(message, cause);
    }
}
