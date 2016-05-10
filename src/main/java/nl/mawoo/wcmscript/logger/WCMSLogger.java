package nl.mawoo.wcmscript.logger;

/**
 * This class is responsible to log items to the console or to the web.
 * In the case the WCMScript is connected to a "manager". The info messages, errors and warnings are stored in a
 * mysql database. This is because on the "manager" there is a console reader what shows the output to the front-end.
 * If WCMScript is not connected to a "manager" the logger just normally outputs to the console as a standard application
 * will.
 *
 * @author Bob van der Valk
 */
public class WCMSLogger {

    private WCMSLogger() {

    }

    /**
     * Initiate a WCMScript logger.
     * This method makes the difference to log to the console using log4j or if a session id is set
     * The application will log to a mysql database.
     *
     * This is needed to view the console output into the console.
     * @param clazz class used to send messages to the logger
     * @return ConsoleLogger or WebLogger
     * TODO: implement the WebLogger
     */
    public static AbstractLogger getLogger(Class clazz) {
        return new ConsoleLogger(clazz);
    }

}
