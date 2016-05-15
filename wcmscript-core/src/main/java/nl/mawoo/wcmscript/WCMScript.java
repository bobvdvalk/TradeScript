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

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import nl.mawoo.wcmscript.exceptions.NoSuchLibraryException;
import nl.mawoo.wcmscript.logger.ScriptLogger;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.UUID;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class WCMScript {
    private final static Logger LOGGER = LoggerFactory.getLogger(WCMScript.class);

    private final ScriptEngine nashorn;
    private final ScriptLogger scriptLogger;
    private final UUID instanceId;
    private final Injector injector;
    private final List<ScriptModule> modules = new ArrayList<>();

    public WCMScript(UUID instanceId, Module... configuration) {
        // This construction allows the caller of this constructor to override certain configurations of the injector
        this(
                ServiceLoader.load(ScriptModule.class),
                instanceId,
                Guice.createInjector(
                        Modules.override(
                                new InjectorConfig(instanceId)
                        ).with(
                                configuration
                        )
                )
        );
    }

    public WCMScript(ServiceLoader<ScriptModule> serviceLoader, UUID instanceId, Injector parentInjector) {
        this.instanceId = instanceId;

        LOGGER.info("Building WCMScript Engine");

        // Instantiate all modules
        for (ScriptModule module : serviceLoader) {
            modules.add(module);
            LOGGER.info("Found module: {}", module.getName());
        }

        // Create the injector
        this.injector = parentInjector.createChildInjector(modules);
        scriptLogger = injector.getInstance(ScriptLogger.class);
        nashorn = injector.getInstance(ScriptEngine.class);

        // Inject all members into modules
        modules.forEach(this.injector::injectMembers);

        // Create standard bindings
        nashorn.getBindings(ScriptContext.ENGINE_SCOPE).put("System", this);
        nashorn.getBindings(ScriptContext.ENGINE_SCOPE).put("Logger", scriptLogger);

        // Load the std library
        try (InputStream stream = getClass().getResourceAsStream("/wcmscript.js")) {
            eval(stream);
        } catch (IOException | ScriptException e) {
            LOGGER.error("Failed to load std library", e);
        }
    }

    /**
     * This method will consume and close an input stream and execute all the code found inside it.
     * You can use this to execute code from a stream resource.
     * Example:
     * <p>
     * <code>
     * InputStream code = getClass().getResourceAsStream("/path/to/my/resource.js");
     * handler.eval(code);
     * </code>
     *
     * @param stream the input stream
     * @throws IOException     if an IO error occurs.
     * @throws ScriptException if an error occurred in the javascript code.
     */
    public void eval(InputStream stream) throws IOException, ScriptException {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            nashorn.eval(reader);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    /**
     * Evaluate a string of  code.
     *
     * @param code the code
     * @throws ScriptException if an error occurs in the javascript code
     */
    public void eval(String code) throws ScriptException {
        nashorn.eval(code);
    }

    /**
     * This method will create a binding for a loaded module.
     *
     * @param moduleName the name of the module
     * @throws IOException            if an IO error occurs while reading the resource
     * @throws ScriptException        if an exception occurs in the javascript code
     * @throws NoSuchLibraryException if the requested resource does not exist
     */
    public void loadModule(String moduleName) throws IOException, ScriptException {
        for (ScriptModule module : modules) {
            if (moduleName.equals(module.getCodeIdentifier())) {
                nashorn.getBindings(ScriptContext.ENGINE_SCOPE).put(module.getCodeIdentifier(), module);
                return;
            }
        }
        throw new NoSuchLibraryException("No library with name " + moduleName + " was found");
    }

    public ScriptLogger getScriptLogger() {
        return scriptLogger;
    }
}
