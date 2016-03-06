package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 6-3-2016.
 */
public class CantUseFileException extends MigrateJSException {
    public CantUseFileException(String message) {
        super(message);
    }

    public CantUseFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
