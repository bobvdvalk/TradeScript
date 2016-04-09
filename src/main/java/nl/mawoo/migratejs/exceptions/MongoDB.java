package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 15-3-2016.
 */
public class MongoDB extends WCMScriptException {

    public MongoDB(String message) {
        super(message);
    }

    public MongoDB(String message, Throwable cause) {
        super(message, cause);
    }
}
