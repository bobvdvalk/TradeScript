/**
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.mawoo.wcmmanager.services;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.*;

/**
 * This class represents the result of the execution of a script.
 * It contains information about how the script was executed and what logging output was found.
 *
 * @author Bob van der Valk
 */
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
