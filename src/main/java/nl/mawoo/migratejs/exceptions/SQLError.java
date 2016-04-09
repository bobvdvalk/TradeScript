package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 15-3-2016.
 */
public class SQLError extends WCMScriptException {
    public SQLError(String message) {
        super(message);
    }

    public SQLError(String message, Throwable cause) {
        super(message, cause);
    }
}
