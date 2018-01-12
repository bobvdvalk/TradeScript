package nl.mawoo.tradescript.service.wcmservice;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.*;

public class ExecutionResult {
    private final Date start = new Date();
    private final UUID executionId;
    private Date initDone;
    private Date executionDone;
    private final List<LogMessage> logging = new ArrayList<>();
    private String error;

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

    public boolean getSuccess() {
        return error == null;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
}
