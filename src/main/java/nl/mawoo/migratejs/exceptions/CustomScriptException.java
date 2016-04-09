package nl.mawoo.migratejs.exceptions;

/**
 * Created by bobva on 09-04-16.
 */
public class CustomScriptException extends WCMScriptException {
    public CustomScriptException(String message) {
        super(message);
    }

    public CustomScriptException(String message, Throwable cause) {
        super(message, cause);
    }
}
