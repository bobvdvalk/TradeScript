package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 14-3-2016.
 */
public class CantSaveFileException extends MigrateJSException {
    public CantSaveFileException(String message) {
        super(message);
    }

    public CantSaveFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
