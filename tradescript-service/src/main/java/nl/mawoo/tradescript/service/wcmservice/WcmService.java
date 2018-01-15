package nl.mawoo.tradescript.service.wcmservice;

import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.wcmscript.WCMScript;
import nl.mawoo.wcmscript.logger.AbstractScriptLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class WcmService {
    private final Logger logger = LoggerFactory.getLogger(WcmService.class);
    private Script script;

    public ExecutionResult run(Script script) {
        this.script = script;
        ExecutionResult result = new ExecutionResult(UUID.randomUUID());
        WCMScript wcmScript = new WCMScript(result.getExecutionId(), new LogConfig(new ScriptLoggerImpl(result)));
        result.initDone();
        try {
            wcmScript.eval(this.openFile());
        } catch (ScriptException e) {
            String message = e.getLocalizedMessage();
            if (message == null) {
                message = e.getClass().getSimpleName();
            }
            result.setError(message);
        } catch (IOException e) {
            logger.error("CANNOT START SCRIPT. CAN'T OPEN FILE", e);
        }
        result.executionDone();
        return result;
    }

    /**
     * Open a .trd file
     *
     * @return InputStream with the code
     */
    private InputStream openFile() {
        InputStream in = null;
        try {
            Path path = Paths.get(script.getPath());
            in = Files.newInputStream(path);
        } catch (IOException e) {
            logger.error("Cannot open: " + script.getFilename(), e);
        }
        return in;
    }

    private class ScriptLoggerImpl extends AbstractScriptLogger {
        private final ExecutionResult result;

        public ScriptLoggerImpl(ExecutionResult result) {
            super("WCMService");
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
