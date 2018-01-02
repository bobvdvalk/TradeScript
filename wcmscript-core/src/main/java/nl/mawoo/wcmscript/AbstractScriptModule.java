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

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import nl.mawoo.wcmscript.logger.ScriptLogger;

import java.util.Properties;

/**
 * This class represents an abstract implementation of the {@link ScriptModule}.
 *
 * @author Bob van der Valk
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
