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
package nl.mawoo.wcmscript.logger;

/**
 * This class provides a simpler api for implementations of the {@link ScriptLogger}.
 *
 * @author Bob van der Valk
 * @author Thomas Biesaart
 */
public abstract class AbstractScriptLogger implements ScriptLogger {
    private final String name;

    public AbstractScriptLogger(String name) {
        this.name = name;
    }

    protected abstract String buildMessage(String format, Object parameter);

    protected abstract String buildMessage(String format, Object parameter1, Object parameter2);

    protected abstract String buildMessage(String format, Object[] parameters);

    protected abstract String buildMessage(String format, Throwable throwable);


    protected abstract void logMessage(MessageType debug, String msg);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void debug(String msg) {
        logMessage(MessageType.DEBUG, msg);
    }

    @Override
    public void debug(String format, Object arg) {
        logMessage(MessageType.DEBUG, buildMessage(format, arg));
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        logMessage(MessageType.DEBUG, buildMessage(format, arg1, arg2));
    }

    @Override
    public void debug(String format, Object... arguments) {
        logMessage(MessageType.DEBUG, buildMessage(format, arguments));
    }

    @Override
    public void debug(String msg, Throwable t) {
        logMessage(MessageType.DEBUG, buildMessage(msg, t));
    }

    @Override
    public void info(String msg) {
        logMessage(MessageType.INFO, msg);
    }

    @Override
    public void info(String format, Object arg) {
        logMessage(MessageType.INFO, buildMessage(format, arg));
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        logMessage(MessageType.INFO, buildMessage(format, arg1, arg2));
    }

    @Override
    public void info(String format, Object... arguments) {
        logMessage(MessageType.INFO, buildMessage(format, arguments));
    }

    @Override
    public void info(String msg, Throwable t) {
        logMessage(MessageType.INFO, buildMessage(msg, t));
    }

    @Override
    public void warn(String msg) {
        logMessage(MessageType.WARN, msg);
    }

    @Override
    public void warn(String format, Object arg) {
        logMessage(MessageType.WARN, buildMessage(format, arg));
    }

    @Override
    public void warn(String format, Object... arguments) {
        logMessage(MessageType.WARN, buildMessage(format, arguments));
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        logMessage(MessageType.WARN, buildMessage(format, arg1, arg2));
    }

    @Override
    public void warn(String msg, Throwable t) {
        logMessage(MessageType.WARN, buildMessage(msg, t));
    }

    @Override
    public void error(String msg) {
        logMessage(MessageType.ERROR, msg);
    }

    @Override
    public void error(String format, Object arg) {
        logMessage(MessageType.ERROR, buildMessage(format, arg));
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        logMessage(MessageType.ERROR, buildMessage(format, arg1, arg2));
    }

    @Override
    public void error(String format, Object... arguments) {
        logMessage(MessageType.ERROR, buildMessage(format, arguments));
    }

    @Override
    public void error(String msg, Throwable t) {
        logMessage(MessageType.ERROR, buildMessage(msg, t));
    }

    protected enum MessageType {
        DEBUG, INFO, WARN, ERROR;
    }
}
