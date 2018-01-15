package nl.mawoo.tradescript.service.scripts;

import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.wcmservice.WcmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class actually starts scripts in the TradeScript Engine
 *
 * @Author Bob van der Valk
 */
public class ScriptEvents {
    private final Logger logger = LoggerFactory.getLogger(ScriptEvents.class);

    private List<ScriptEventListener> subscribers = new ArrayList<>();
    private final Script script;

    public ScriptEvents(Script script) {
        this.script = script;
        // add listeners
        subscribers.add(new WcmService());
    }

    /**
     * If a event is happening to a script instance. Call this method
     */
    public void event() {
        for(ScriptEventListener listener : subscribers) {
            listener.update();
        }
    }
}
