package nl.mawoo.migratejs.exceptions;

/**
 * If a user want to use the use() function.
 *
 * @author Bob van der Valk
 */
public class CantFindLibraryException extends MigrateJSException {
    public CantFindLibraryException(String message) {
        super(message);
    }

    public CantFindLibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}
