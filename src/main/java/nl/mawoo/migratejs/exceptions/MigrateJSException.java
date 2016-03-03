package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 3-3-2016.
 */
public class MigrateJSException extends RuntimeException {
    public MigrateJSException(String message) {
        super(message);
    }

    public MigrateJSException(String message, Throwable cause) {
        super(message, cause);
    }
}
