package nl.mawoo.wcmscript;

import nl.mawoo.wcmscript.scriptengine.ScriptHandler;

import org.apache.log4j.Logger;
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

    private static Logger log = Logger.getLogger(WCMScript.class.getName());

    private WCMScript() {

    }

    public static void main(String... args) {

        ScriptHandler scriptHandler = new ScriptHandler();

        if(args.length > 0){

            String path = args[0];

            try {
                log.info("WCMScript - Version 1.0 \n");
                scriptHandler.fileReader(path);
            } catch (FileNotFoundException e) {
                log.error("Load file not found. The file you want to use cannot be found."+ e);
            } catch (ScriptException e) {
                log.error("Error in script", e);
            }
        } else {
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
