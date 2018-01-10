package nl.mawoo.tradescript.service.scripts;

import nl.mawoo.tradescript.service.exceptions.UnableToStartException;
import nl.mawoo.tradescript.service.exceptions.UnableToStopException;
import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import nl.mawoo.tradescript.service.storage.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartStop implements StartStopInterface {
    private final Logger logger = LoggerFactory.getLogger(StartStop.class);

    private final ScriptDao scriptDao;

    public StartStop(ScriptDao scriptDao) {
        this.scriptDao = scriptDao;
    }


    @Override
    public Script start(String filename) throws UnableToStartException {
        logger.info("Starting: "+ filename +" script");
        Script script = scriptDao.findByFilename(filename);
        if(script != null) {
            script.setStatus(Status.RUNNING);
            scriptDao.save(script);
        } else {
            throw new UnableToStartException();
        }
        return script;
    }

    @Override
    public Script stop(String filename) throws UnableToStopException {
        Script script = scriptDao.findByFilename(filename);
        script.setStatus(Status.STOPPED);
        scriptDao.save(script);
        return script;
    }
}
