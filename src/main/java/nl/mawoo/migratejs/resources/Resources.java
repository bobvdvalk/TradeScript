package nl.mawoo.migratejs.resources;

import nl.mawoo.migratejs.exceptions.CantFindLibraryException;
import nl.mawoo.migratejs.scriptengine.ScriptHandler;

import javax.script.ScriptEngine;
import java.io.File;

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
        File file = null;

        try {
            file = new File(classLoader.getResource(library).getFile());
        } catch (NullPointerException e) {
            throw new CantFindLibraryException("The library you want to use does not exist");
        }

        return file.getAbsolutePath();
    }
}
