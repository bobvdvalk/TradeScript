package nl.mawoo.migratejs.extend;

import javax.script.ScriptEngine;

/**
 * Created by Bob on 3-3-2016.
 */
public class Importer {
    /**
     * Load classes that need the script engine.
     * @param engine ScriptEngine to use the running javascript engine.
     */
    public Importer(ScriptEngine engine) {
        // include files into js
        new Include(engine);
    }
}
