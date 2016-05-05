package nl.mawoo.wcmscript.extend.main;

import nl.mawoo.wcmscript.logger.AbstractLogger;
import nl.mawoo.wcmscript.logger.WCMSLogger;

/**
 * This class is responsible to print something in the console
 *
 * @author Bob van der Valk
 */
public class Print {
    /**
     * Print a message
     * @param message String of text you want to output.
     */
    public static void message(String message) {
        AbstractLogger logger = WCMSLogger.getLogger(Print.class);
        logger.info(message);
    }
}
