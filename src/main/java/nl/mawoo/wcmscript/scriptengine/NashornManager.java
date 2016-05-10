package nl.mawoo.wcmscript.scriptengine;

import nl.mawoo.wcmscript.exceptions.CantFindLibrary;
import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class NashornManager {

    private ScriptEngine nashorn;
    private static Logger logger = Logger.getLogger(NashornManager.class.getName());

    public NashornManager(ScriptEngine nashorn) {
        this.nashorn = nashorn;
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
            nashorn.eval(reader);
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
     * // To load the wcmscript.js resource from the jar
     * handler.loadResource("/wcmscript.js");
     * </code>
     *
     * @param resourceName the path to the resource.
     * @throws IOException              if an IO error occurs while reading the resource
     * @throws ScriptException          if an exception occurs in the javascript code
     * @throws CantFindLibrary if the requested resource does not exist
     */
    public void loadResource(String resourceName) throws IOException, ScriptException {
        InputStream stream = getClass().getResourceAsStream(resourceName);

        if (stream == null) {
            logger.error("No library called " + resourceName + " was found");
        }

        eval(stream);
    }
}
