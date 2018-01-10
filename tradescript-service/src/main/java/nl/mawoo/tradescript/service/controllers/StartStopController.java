package nl.mawoo.tradescript.service.controllers;

import nl.mawoo.tradescript.service.exceptions.UnableToStartException;
import nl.mawoo.tradescript.service.exceptions.UnableToStopException;
import nl.mawoo.tradescript.service.scripts.StartStop;
import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class StartStopController {
    private final Logger logger = LoggerFactory.getLogger(StartStopController.class);

    @Autowired
    private ScriptDao scriptDao;

    @RequestMapping("/start")
    @ResponseBody
    public Script start(@RequestParam String filename) {
        StartStop startStop = new StartStop(scriptDao);
        Script script = null;
        try {
            script = startStop.start(filename);
        } catch (UnableToStartException e) {
            logger.error("Cannot start script with filename: "+ filename, e);
        }
        return script;
    }

    @RequestMapping("/stop")
    @ResponseBody
    public Script stop(@RequestParam String filename) {
        StartStop startStop = new StartStop(scriptDao);
        Script script = null;
        try {
            script = startStop.stop(filename);
        } catch (UnableToStopException e) {
            logger.error("Cannot stop script with filename: "+ filename, e);
        }
        return script;
    }
}
