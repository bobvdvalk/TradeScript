package nl.mawoo.migratejs;

import nl.mawoo.migratejs.scriptengine.ScriptHandler;

import javax.script.ScriptException;
import java.io.FileNotFoundException;

/**
 * Created by Bob on 3-3-2016.
 */
public class Main {
    public static void main(String... args) {

        ScriptHandler scriptHandler = new ScriptHandler();

        if(args.length > 0){

            String path = args[0];

            try {
                scriptHandler.fileReader(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("geen args");
        }
    }
}
