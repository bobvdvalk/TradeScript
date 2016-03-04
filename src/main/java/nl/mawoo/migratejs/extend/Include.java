package nl.mawoo.migratejs.extend;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Bob on 3-3-2016.
 */
public class Include {

    ScriptEngine engine;

    /**
     * Set up with the engine to execute functions.
     * @param engine scriptengine
     */
    public Include() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        engine = engineManager.getEngineByName("nashorn");
    }

    /**
     * Import a js file into the runtime.
     * @param path path of the js file you want to include.
     */
    public void load(String path) {

        try {
            engine.eval(new FileReader(path));
        } catch (ScriptException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
