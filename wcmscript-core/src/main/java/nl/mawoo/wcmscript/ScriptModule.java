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

import com.google.inject.Module;

/**
 * This interface represents a module that can be loaded into WCMScript.
 * It is the entry-point of the plugin system.
 * <p>
 * Implementations of this interface are loaded by the {@link java.util.ServiceLoader}. This means that to enable
 * loading of modules you should add the entry to META-INF/services/nl.mawoo.wcmscript.ScriptModule.
 * <p>
 * Implementations of this interface must have an empty constructor. After the constructor is invoked the members will
 * by injected by the framework. This means only member and method injection can be used.
 *
 * @author Bob van der Valk
 * @see AbstractScriptModule
 */
public interface ScriptModule extends Module {
    /**
     * Get the name of this module. This name will be used to load and identify the module.
     *
     * @return the name
     */
    String getName();

    /**
     * Get the name of the variable mapping for this module.
     * <p>
     * This will be the name of the entry-point in the scripting language.
     *
     * @return the code name
     */
    String getCodeIdentifier();
}
