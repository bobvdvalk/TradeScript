package nl.mawoo.wcmscript.cli;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import nl.mawoo.wcmscript.logger.ScriptLogger;


public class CLILogginConfig extends AbstractModule {
    protected void configure() {

    }

    @Provides
    ScriptLogger scriptLogger() {
        return new CLIScriptLogger();
    }
}
