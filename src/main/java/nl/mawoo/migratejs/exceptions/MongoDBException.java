package nl.mawoo.migratejs.exceptions;

/**
 * Created by Bob on 15-3-2016.
 */
public class MongoDBException extends WCMScriptException {

    public MongoDBException(String message) {
        super(message);
    }

    public MongoDBException(String message, Throwable cause) {
        super(message, cause);
    }
}
