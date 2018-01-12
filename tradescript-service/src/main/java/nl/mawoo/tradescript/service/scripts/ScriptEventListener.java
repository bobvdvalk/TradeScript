package nl.mawoo.tradescript.service.scripts;

import nl.mawoo.tradescript.service.storage.Script;

public abstract class ScriptEventListener {
    protected Script script;

    public ScriptEventListener(Script script) {
        this.script = script;
    }

    /**
     * The event if the status changes.
     */
    public abstract void update();
}
