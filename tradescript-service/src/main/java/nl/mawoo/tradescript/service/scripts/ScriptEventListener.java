package nl.mawoo.tradescript.service.scripts;

import nl.mawoo.tradescript.service.storage.Script;

public interface ScriptEventListener {
    /**
     * The event if the status changes.
     */
    void start(Script script);

    void stop(Script script);
}
