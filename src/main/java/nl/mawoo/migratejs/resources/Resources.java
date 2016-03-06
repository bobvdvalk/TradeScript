package nl.mawoo.migratejs.resources;

import nl.mawoo.migratejs.exceptions.CantUseFileException;
import nl.mawoo.migratejs.input.InputHandler;
import nl.mawoo.migratejs.scriptengine.ScriptHandler;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * This class is responsible to load MigrateJS resources into the user system.
 *
 * @author Bob van der Valk
 */
public class Resources {

    public String use(String library) {
        ScriptHandler scriptHandler = new ScriptHandler();
        ScriptEngine engine = scriptHandler.getEngine();

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(library).getFile());

        return file.getAbsolutePath();
    }
}
