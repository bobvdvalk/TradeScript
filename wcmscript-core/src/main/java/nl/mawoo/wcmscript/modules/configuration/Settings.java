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
package nl.mawoo.wcmscript.modules.configuration;

import nl.mawoo.wcmscript.AbstractScriptModule;
import nl.mawoo.wcmscript.PropertyConfig;

import java.util.Properties;

/**
 * This class is used to manage settings within a TradeScript.
 */
public class Settings extends AbstractScriptModule {
    private final Properties properties = new PropertyConfig().load();

    /**
     * Get a property from the config.properties file.
     *
     * @param key String name of the key in the file
     * @return data from the properties file
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
