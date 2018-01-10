package nl.mawoo.tradescript.service.scripts;

import nl.mawoo.tradescript.service.exceptions.UnableToStartException;
import nl.mawoo.tradescript.service.exceptions.UnableToStopException;
import nl.mawoo.tradescript.service.storage.Script;

public interface StartStopInterface {
    /**
     * Stop a running script
     * @param filename name of the script you want to stop
     * @return updated Script database row with the new Status
     * @see nl.mawoo.tradescript.service.storage.Status
     */
    Script start(String filename) throws UnableToStartException;

    /**
     * Stop a running script
     * @param filename name of the script you want to stop
     * @return updated Script database row with the new Status
     * @see nl.mawoo.tradescript.service.storage.Status
     */
    Script stop(String filename) throws UnableToStopException;
}
