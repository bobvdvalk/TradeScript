package nl.mawoo.migratejs;

import nl.mawoo.migratejs.scriptengine.ScriptHandler;

import org.apache.log4j.Logger;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main class to run WCMScript
 */
public class WCMScript {

    private static Logger log = Logger.getLogger(WCMScript.class.getName());

    public static void main(String... args) {

        ScriptHandler scriptHandler = new ScriptHandler();

        if(args.length > 0){

            String path = args[0];

            try {
                log.info("WCMScript - Version 1.0 \n");
                scriptHandler.fileReader(path);
            } catch (FileNotFoundException e) {
                log.error("Load file not found.");
            } catch (ScriptException e) {
                log.error("Error in script", e);
            }
        } else {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                try {
                    System.out.print(">");
                    String input = br.readLine();

                    scriptHandler.stringReader(input);
                } catch (IOException | ScriptException e) {
                    log.error("Error in script");
                }
            }
        }
    }
}
