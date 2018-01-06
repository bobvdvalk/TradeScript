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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyConfig implements PropertyInterface {

    private final String filename = "config.properties";
    private final Properties properties = new Properties();
    private final Logger logger = LoggerFactory.getLogger(PropertyConfig.class);

    /**
     * Load default property file
     *
     * @return Java.util.Properties
     */
    public Properties load() {
        try {
            // Generate new file if it not exists.
            if (!Files.exists(Paths.get(filename))) {
                this.generateProperties();
            }
            InputStream input = new FileInputStream(filename);
            properties.load(input);
        } catch (FileNotFoundException e) {
            logger.error("Cannot find property file", e);
        } catch (IOException e) {
            logger.error("Something went wrong reading property file", e);
        }
        return properties;
    }

    /**
     * Generate new property file with default values that doesn't make sense.
     */
    private void generateProperties() {
        OutputStream output = null;
        try {
            output = new FileOutputStream(filename);
            properties.setProperty("bunq", "Fill this in to use Bunq API");
            properties.setProperty("bitstamp-public", "Fill this in to use Bitstamp exchange");
            properties.setProperty("bitstamp-secret", "Fill this in to use Bitstamp exchange");
            properties.setProperty("GDAX", "Fill this in to use GDAX exchange");
            properties.store(output, null);
        } catch (IOException e) {
            logger.error("Cannot save properties file.", e);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    logger.error("Cannout close properties file", e);
                }
            }
        }
    }
}
