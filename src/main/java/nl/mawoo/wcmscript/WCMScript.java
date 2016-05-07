package nl.mawoo.wcmscript;

import nl.mawoo.wcmscript.logger.AbstractLogger;
import nl.mawoo.wcmscript.logger.WCMSLogger;
import nl.mawoo.wcmscript.scriptengine.ScriptHandler;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main class to run WCMScript
 *
 * @author Bob van der Valk
 */
public class WCMScript {

    private WCMScript() {

    }

    public static void main(String[] args) {
        if(args.length > 0){

            String path = args[0];
            ScriptHandler scriptHandler = null;
            /**
             * Set the session id if given
             */
            if(args[1] != null) {
                scriptHandler = new ScriptHandler(args[1]);
            } else {
                scriptHandler = new ScriptHandler();
            }

            AbstractLogger log = WCMSLogger.getLogger(WCMScript.class);

            scriptHandler.run();

            try {
                log.info("WCMScript - Version 1.0 \n");
                scriptHandler.fileReader(path);
            } catch (FileNotFoundException e) {
                log.error("Load file not found. The file you want to use cannot be found."+ e);
            } catch (ScriptException e) {
                log.error("Error in script", e);
            } catch (Exception e) {
                log.error("Uncaught exception", e);
            } finally {
                log.info("------- DONE -------");
            }
        } else {
            ScriptHandler scriptHandler = new ScriptHandler();
            AbstractLogger log = WCMSLogger.getLogger(WCMScript.class);

            log.info("WCMScript - Version 1.0 \n");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                try {
                    System.out.print(">");
                    String input = br.readLine();
                    scriptHandler.stringReader(input);
                } catch (IOException | ScriptException e) {
                    log.error("Error in script", e);
                } catch (Exception e) {
                    log.error("Uncaught exception"+ e);
                } finally {
                    log.info("------- DONE -------");
                }
            }
        }
    }
}
