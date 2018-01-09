package nl.mawoo.tradescript.service.workspace;

import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReloadWorkspaces implements ReloadInterface {
    private final Logger logger = LoggerFactory.getLogger(ReloadWorkspaces.class);

    private final String folder;
    private final ScriptDao scriptDao;

    public ReloadWorkspaces(String folder, ScriptDao scriptDao) {
        this.folder = folder;
        this.scriptDao = scriptDao;
    }

    /**
     * Update the current workspace
     * @return
     */
    @Override
    public Iterable<Script> update() {
        Workspace workspace = new Workspace(scriptDao, folder);
        List<Script> scriptList = workspace.scanWorkspace();
        for(Script script : scriptList) {
            Script foundScript = null;
            foundScript = scriptDao.findByFilename(script.getFilename());
            if(foundScript == null) {
                scriptDao.save(script);
            }
        }
        return scriptDao.findAll();
    }

    /**
     * Reset the current workspace. Everything is automatically uninstalled and not running.
     * @return boolean if the reset was successful
     */
    public boolean reset() {
        logger.info("Refreshing workspace");
        scriptDao.deleteAll();
        Workspace workspace = new Workspace(scriptDao, this.folder);
        workspace.scanWorkspace();
        workspace.save();
        return true;
    }
}
