package nl.mawoo.wcmscript.exceptions;

/**
 * This exception is generally thrown whenever a library is requested that does not exist.
 *
 * @author Thomas Biesaart
 */
public class NoSuchLibraryException extends WCMScriptException {
    public NoSuchLibraryException(String message) {
        super(message);
    }
}
