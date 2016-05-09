package nl.mawoo.wcmscript.logger;


import nl.mawoo.wcmscript.scriptengine.ScriptHandler;
import nl.mawoo.wcmscript.scriptengine.ScriptHandler2;

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

    public static AbstractLogger getLogger(Class clazz) {
        String sessionId = ScriptHandler2.getSessionId();

        if(sessionId != null) {
            return new ConsoleLogger();
        } else {
            return new WebLogger(sessionId);
        }
    }

}
