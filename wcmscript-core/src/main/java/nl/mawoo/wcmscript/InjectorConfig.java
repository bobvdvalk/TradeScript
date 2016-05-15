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
import com.google.inject.Provides;
import nl.mawoo.wcmscript.logger.ScriptLogger;

import javax.inject.Named;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.UUID;


/**
 * This class contains the injection configuration for WCMScript.
 *
 * @author Thomas Biesaart
 */
class InjectorConfig extends AbstractModule {
    private final UUID instanceId;

    InjectorConfig(UUID instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    protected void configure() {
        bind(ScriptLogger.class).toProvider(CLIScriptLogger::new);
        bind(ScriptEngine.class).toProvider(() -> new ScriptEngineManager().getEngineByName("nashorn"));
    }

    @Provides
    @Named("wcms.instanceId")
    UUID instanceId() {
        return instanceId;
    }
}
