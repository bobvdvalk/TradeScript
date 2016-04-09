package nl.mawoo.migratejs.exceptions;

/**
 * Created by bobva on 09-04-16.
 */
public class CustomScript extends WCMScriptException {
    public CustomScript(String message) {
        super(message);
    }

    public CustomScript(String message, Throwable cause) {
        super(message, cause);
    }
}
