package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 15-3-2016.
 */
public class SQLException extends WCMScriptException {
    public SQLException(String message) {
        super(message);
    }

    public SQLException(String message, Throwable cause) {
        super(message, cause);
    }
}
