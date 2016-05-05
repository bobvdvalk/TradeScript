package nl.mawoo.wcmscript;

import nl.mawoo.wcmscript.extend.importer.ExcelImport;
import nl.mawoo.wcmscript.logger.AbstractLogger;
import nl.mawoo.wcmscript.logger.WCMSLogger;
import nl.mawoo.wcmscript.logger.WCMSProperties;
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
        ScriptHandler scriptHandler = new ScriptHandler();

        if(args.length > 0){

            String path = args[0];

            if(args[1] != null) {
                WCMSProperties.create(args[1]);
            } else {
                WCMSProperties.create();
            }

            AbstractLogger log = WCMSLogger.getLogger(WCMScript.class);

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
                log.info("WCMScript is done");
            }
        } else {
            WCMSProperties.create();
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
                }
            }
        }
    }
}
