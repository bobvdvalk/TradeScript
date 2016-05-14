package nl.mawoo.wcmmanager.services;

import java.util.*;

/**
 * This class represents the result of the execution of a script.
 * It contains information about how the script was executed and what logging output was found.
 *
 * @author Thomas Biesaart
 */
public class ExecutionResult {
    private final Date start = new Date();
    private final UUID executionId;
    private Date initDone;
    private Date executionDone;
    private final List<LogMessage> logging = new ArrayList<>();

    public ExecutionResult(UUID executionId) {
        this.executionId = executionId;
    }

    public void initDone() {
        initDone = new Date();
    }

    public void executionDone() {
        executionDone = new Date();
    }

    public long getInitializationTime() {
        return initDone.getTime() - start.getTime();
    }

    public long getExecutionTime() {
        return executionDone.getTime() - initDone.getTime();
    }

    public List<LogMessage> getLogging() {
        return Collections.unmodifiableList(logging);
    }

    public UUID getExecutionId() {
        return executionId;
    }

    public void add(LogMessage message) {
        logging.add(message);
    }

    public static class LogMessage {
        private final String message;
        private final String level;
        private final long timeStamp;

        public LogMessage(String message, String level) {
            this(message, level, System.currentTimeMillis());
        }

        public LogMessage(String message, String level, long timeStamp) {
            this.message = message;
            this.level = level;
            this.timeStamp = timeStamp;
        }

        public String getMessage() {
            return message;
        }

        public String getLevel() {
            return level;
        }

        public long getTimeStamp() {
            return timeStamp;
        }
    }

    public static class ErrorLogMessage extends LogMessage {
        private final Throwable error;

        public ErrorLogMessage(String message, String level, Throwable error) {
            super(message, level);
            this.error = error;
        }

        public Throwable getError() {
            return error;
        }
    }
}
