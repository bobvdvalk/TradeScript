package nl.mawoo.tradescript.service.wcmservice;

import com.google.inject.AbstractModule;
import nl.mawoo.wcmscript.logger.ScriptLogger;

public class LogConfig extends AbstractModule {
    private final ScriptLogger logger;

    public LogConfig(ScriptLogger scriptLogger) {
        this.logger = scriptLogger;
    }

    @Override
    protected void configure() {
        bind(ScriptLogger.class).toInstance(logger);
    }
}
