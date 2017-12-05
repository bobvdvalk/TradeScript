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
package nl.mawoo.wcmscript.cli;


import nl.mawoo.wcmscript.WCMScript;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * This class represents the console application wrapper around the WCMScript implementation.
 * <p>
 * The command line interface allows you to stream in code over std in that is executed live. If an error occurs
 * execution of the current line will be stopped.
 *
 * @author Bob van der Valk
 */
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException, ScriptException {
        UUID instanceId = UUID.randomUUID();
        WCMScript wcmScript = new WCMScript(instanceId);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int indentation = 0;
        StringBuilder code = new StringBuilder();
        while (true) {
            try {
                System.out.print("> " + StringUtils.repeat("  ", indentation));
                String line = bf.readLine();
                indentation += StringUtils.countMatches(line, '{');
                indentation -= StringUtils.countMatches(line, '}');
                code.append(line).append('\n');

                if (indentation == 0) {
                    eval(wcmScript, code);
                }
            } catch (IOException e) {
                LOGGER.error("IO exception: " + e.getMessage(), e);
            }
        }
    }

    private static void eval(WCMScript wcmScript, StringBuilder code) {
        try {
            wcmScript.eval(code.toString());
        } catch (ScriptException e) {
            wcmScript.getScriptLogger().error("SCRIPT ERROR: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Uncaught exception: " + e.getMessage(), e);
        } finally {
            code.setLength(0);
        }
    }
}
