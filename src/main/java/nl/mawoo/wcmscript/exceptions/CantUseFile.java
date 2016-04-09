package nl.mawoo.wcmscript.exceptions;

/**
 * Created by Bob on 6-3-2016.
 */
public class CantUseFile extends WCMScriptException {
    public CantUseFile(String message) {
        super(message);
    }

    public CantUseFile(String message, Throwable cause) {
        super(message, cause);
    }
}
