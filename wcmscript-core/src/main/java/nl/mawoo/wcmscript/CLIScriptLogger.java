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
package nl.mawoo.wcmscript;

import nl.mawoo.wcmscript.logger.ScriptLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This logger will output all messages to the console using slf4j.
 *
 * @author Thomas Biesaart
 */
class CLIScriptLogger implements ScriptLogger {
    private final static Logger LOGGER = LoggerFactory.getLogger("WCMS");

    @Override
    public String getName() {
        return LOGGER.getName();
    }

    @Override
    public void debug(String msg) {
        LOGGER.debug(msg);
    }

    @Override
    public void debug(String format, Object arg) {
        LOGGER.debug(format, arg);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        LOGGER.debug(format, arg1, arg2);
    }

    @Override
    public void debug(String format, Object... arguments) {
        LOGGER.debug(format, arguments);
    }

    @Override
    public void debug(String msg, Throwable t) {
        LOGGER.debug(msg, t);
    }

    @Override
    public void info(String msg) {
        LOGGER.info(msg);
    }

    @Override
    public void info(String format, Object arg) {
        LOGGER.info(format, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        LOGGER.info(format, arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        LOGGER.info(format, arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        LOGGER.info(msg, t);
    }

    @Override
    public void warn(String msg) {
        LOGGER.warn(msg);
    }

    @Override
    public void warn(String format, Object arg) {
        LOGGER.warn(format, arg);
    }

    @Override
    public void warn(String format, Object... arguments) {
        LOGGER.warn(format, arguments);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        LOGGER.warn(format, arg1, arg2);
    }

    @Override
    public void warn(String msg, Throwable t) {
        LOGGER.warn(msg, t);
    }

    @Override
    public void error(String msg) {
        LOGGER.error(msg);
    }

    @Override
    public void error(String format, Object arg) {
        LOGGER.error(format, arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        LOGGER.error(format, arg1, arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        LOGGER.error(format, arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        LOGGER.error(msg, t);
    }
}
