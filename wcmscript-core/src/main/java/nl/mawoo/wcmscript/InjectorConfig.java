package nl.mawoo.wcmscript;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.UUID;


/**
 * This class contains the injection configuration for WCMScript.
 *
 * @author Thomas Biesaart
 */
class InjectorConfig extends AbstractModule {
    private final UUID instanceId;

    public InjectorConfig(UUID instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    protected void configure() {

    }

    @Provides
    ScriptEngine scriptEngine() {
        return new ScriptEngineManager().getEngineByName("nashorn");
    }

    @Provides
    @Named("wcms.instanceId")
    UUID instanceId() {
        return instanceId;
    }
}
