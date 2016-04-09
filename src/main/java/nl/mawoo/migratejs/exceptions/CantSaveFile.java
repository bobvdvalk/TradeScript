package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 14-3-2016.
 */
public class CantSaveFile extends WCMScriptException {
    public CantSaveFile(String message) {
        super(message);
    }

    public CantSaveFile(String message, Throwable cause) {
        super(message, cause);
    }
}
