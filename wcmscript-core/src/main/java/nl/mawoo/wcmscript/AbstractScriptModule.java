package nl.mawoo.wcmscript;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import nl.mawoo.wcmscript.logger.ScriptLogger;

/**
 * This class represents an abstract implementation of the {@link ScriptModule}.
 *
 * @author Thomas Biesaart
 */
public abstract class AbstractScriptModule extends AbstractModule implements ScriptModule {
    private final String codeIdentity;
    private final String moduleName;
    private ScriptLogger scriptLogger;

    protected AbstractScriptModule() {
        codeIdentity = getClass().getSimpleName();
        moduleName = getClass().getSimpleName();
    }

    public AbstractScriptModule(String codeIdentity) {
        this(codeIdentity, codeIdentity);
    }

    public AbstractScriptModule(String codeIdentity, String moduleName) {
        this.codeIdentity = codeIdentity;
        this.moduleName = moduleName;
    }

    @Override
    public String getName() {
        return moduleName;
    }

    @Override
    public String getCodeIdentifier() {
        return codeIdentity;
    }

    @Override
    protected void configure() {

    }

    @Inject
    void setScriptLogger(ScriptLogger scriptLogger) {
        this.scriptLogger = scriptLogger;
    }

    public ScriptLogger getScriptLogger() {
        if (scriptLogger == null) {
            throw new IllegalStateException("You cannot use the script logger in your constructor!");
        }
        return scriptLogger;
    }
}
