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
package nl.mawoo.wcmmanager.controller;

import nl.mawoo.wcmmanager.services.ExecutionResult;
import nl.mawoo.wcmmanager.services.WCMScriptService;
import nl.mawoo.wcmmanager.storage.Script;
import nl.mawoo.wcmmanager.storage.ScriptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.ScriptException;
import java.sql.Date;

/**
 * WCMS Fiddle
 * This class is responsible for running the editor for testing code
 * Also it views the WCMScript output in the console.
 *
 * @author Bob van der Valk
 */
@Controller
@RequestMapping("/fiddle")
public class Fiddle {
    private final WCMScriptService scriptService;

    @Autowired
    private ScriptDao scriptDao;

    @Autowired
    public Fiddle(WCMScriptService scriptService) {
        this.scriptService = scriptService;
    }

    /**
     * Run the fiddle editor
     *
     * @return editor.html in template folder
     */
    @RequestMapping("")
    @SuppressWarnings("squid:S3400") // This is how to load a template
    public String editor() {
        return "editor";
    }

    /**
     * Handle the run command. To run a WCMScript into the Fiddle.
     *
     * @param content javascript input for the WCMScript
     * @return nothing
     */
    @ResponseBody
    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ExecutionResult run(@RequestParam("code") String content) throws ScriptException {
        return scriptService.run(content);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestParam("code") String content, @RequestParam("name") String name) {
        scriptDao.save(new Script(name, content, new Date(new java.util.Date().getTime())));
        return "succes";
    }

    /**
     * Responsible to show the console output
     *
     * @return console output page
     */
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @SuppressWarnings("squid:S3400") // This is how to load a template
    public String consoleOutput() {
        return "console";
    }
}
