package nl.mawoo.tradescript.service.workspace;

import nl.mawoo.tradescript.service.storage.Script;

public interface ReloadInterface {
    Iterable<Script> update();
    boolean reset();
}
