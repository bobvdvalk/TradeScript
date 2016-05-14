package nl.mawoo.wcmmanager.services;

import com.google.inject.AbstractModule;
import nl.mawoo.wcmscript.WCMScript;
import nl.mawoo.wcmscript.logger.AbstractScriptLogger;
import nl.mawoo.wcmscript.logger.ScriptLogger;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.util.UUID;

/**
 * This service is responsible for the execution of WCMScript scripts.
 *
 * @author Thomas Biesaart
 */
@Service
public class WCMScriptService {

    public ExecutionResult run(String content) throws ScriptException {
        ExecutionResult result = new ExecutionResult(UUID.randomUUID());
        WCMScript wcmScript = new WCMScript(result.getExecutionId(), new LoggingConfig(new ScriptLoggerImpl(result)));
        result.initDone();
        try {
            wcmScript.eval(content);
        } catch (Exception e) {
            result.setError(e.getLocalizedMessage());
        }
        result.executionDone();
        return result;
    }

    private class LoggingConfig extends AbstractModule {

        private final ScriptLogger logger;

        private LoggingConfig(ScriptLogger logger) {
            this.logger = logger;
        }

        @Override
        protected void configure() {
            bind(ScriptLogger.class).toInstance(logger);
        }
    }

    private class ScriptLoggerImpl extends AbstractScriptLogger {

        private final ExecutionResult result;

        public ScriptLoggerImpl(ExecutionResult result) {
            super("WCMS");
            this.result = result;
        }

        @Override
        protected String buildMessage(String format, Object parameter) {
            return MessageFormatter.format(format, parameter).getMessage();
        }

        @Override
        protected String buildMessage(String format, Object parameter1, Object parameter2) {
            return MessageFormatter.format(format, parameter1, parameter2).getMessage();
        }

        @Override
        protected String buildMessage(String format, Object[] parameters) {
            return MessageFormatter.arrayFormat(format, parameters).getMessage();
        }

        @Override
        protected String buildMessage(String format, Throwable throwable) {
            return MessageFormatter.arrayFormat(format, new Object[0], throwable).getMessage();
        }

        @Override
        protected void logMessage(MessageType type, String msg) {
            result.add(new ExecutionResult.LogMessage(msg, type.name()));
        }
    }
}
