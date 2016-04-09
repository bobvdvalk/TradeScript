package nl.mawoo.migratejs.scriptengine;

import nl.mawoo.migratejs.exceptions.CantFindLibraryException;
import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import sun.font.Script;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * This class is repsonible for running the nashorn script engine
 *
 * @author Bob van der Valk
 */
public class ScriptHandler {
    private ScriptEngine engine;
    private Logger logger = Logger.getLogger(ScriptHandler.class.getName());

    public ScriptHandler() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        engine = engineManager.getEngineByName("nashorn");

        // Bind this engine to the system variable.
        engine.getBindings(ScriptContext.GLOBAL_SCOPE).put("system", this);
        try {
            loadResource("/migratejs.js");
        } catch (ScriptException e) {
            logger.error("Error with the script: "+ e);
        } catch (IOException e) {
            logger.error("IO exception: "+ e);
        }
    }

    /**
     * Read a file into the script engine
     *
     * @param path path to the file you want to use
     * @throws FileNotFoundException
     * @throws ScriptException
     */
    public void fileReader(String path) throws FileNotFoundException, ScriptException {
        engine.eval(new FileReader(path));
    }

    /**
     * Read a string into the script engine
     *
     * @param input user input
     * @throws ScriptException
     */
    public void stringReader(String input) throws ScriptException {
        engine.eval(input);
    }

    /**
     * This method will consume and close an input stream and execute all the code found inside it.
     * You can use this to execute code from a stream resource.
     * Example:
     * <p>
     * <code>
     * InputStream code = getClass().getResourceAsStream("/path/to/my/resource.js");
     * handler.eval(code);
     * </code>
     *
     * @param stream the input stream
     * @throws IOException     if an IO error occurs.
     * @throws ScriptException if an error occurred in the javascript code.
     */
    public void eval(InputStream stream) throws IOException, ScriptException {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            engine.eval(reader);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    /**
     * This method allows you to conveniently load an embedded resource. It will grab the resource and stream it to
     * the engine.
     * <p>
     * Example:
     * <code>
     * // To load the migratejs.js resource from the jar
     * handler.loadResource("/migratejs.js");
     * </code>
     *
     * @param resourceName the path to the resource.
     * @throws IOException              if an IO error occurs while reading the resource
     * @throws ScriptException          if an exception occurs in the javascript code
     * @throws CantFindLibraryException if the requested resource does not exist
     */
    public void loadResource(String resourceName) throws IOException, ScriptException {
        InputStream stream = getClass().getResourceAsStream(resourceName);

        if (stream == null) {
            throw new CantFindLibraryException("No library called " + resourceName + " was found");
        }

        eval(stream);
    }

    public ScriptEngine getEngine() {
        return engine;
    }
}
