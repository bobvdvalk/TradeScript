package nl.mawoo.migratejs.exceptions;

/**
 * If a user want to use the use() function.
 *
 * @author Bob van der Valk
 */
public class CantFindLibrary extends WCMScriptException {
    public CantFindLibrary(String message) {
        super(message);
    }

    public CantFindLibrary(String message, Throwable cause) {
        super(message, cause);
    }
}
