package nl.mawoo.tradescript.service.wcmservice;

import nl.mawoo.tradescript.service.scripts.ScriptEventListener;
import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.Status;
import nl.mawoo.wcmscript.WCMScript;
import nl.mawoo.wcmscript.logger.AbstractScriptLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class WcmService extends ScriptEventListener {
    private final Logger logger = LoggerFactory.getLogger(WcmService.class);

    public WcmService(Script script) {
        super(script);
    }

    @Override
    public void update() {
        Status status = this.script.getStatus();
        switch (status) {
            case RUNNING:
                // start new instance
                this.run();
                break;
            case STOPPED:
                // stop the instance;
                this.stop();
                break;
        }
    }

    private void run() {
        Runnable runnable = () -> {
            ExecutionResult result = new ExecutionResult(UUID.randomUUID());
            WCMScript wcmScript = new WCMScript(result.getExecutionId());
        };
    }

    private void stop() {

    }

    private class ScriptLoggerImpl extends AbstractScriptLogger {
        private final ExecutionResult result;

        public ScriptLoggerImpl(ExecutionResult result) {
            super("WCMService");
            this.result = result;
        }

        @Override
        protected String buildMessage(String format, Object parameter) {
            return null;
        }

        @Override
        protected String buildMessage(String format, Object parameter1, Object parameter2) {
            return null;
        }

        @Override
        protected String buildMessage(String format, Object[] parameters) {
            return null;
        }

        @Override
        protected String buildMessage(String format, Throwable throwable) {
            return null;
        }

        @Override
        protected void logMessage(MessageType debug, String msg) {

        }
    }
}
