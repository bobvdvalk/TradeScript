package nl.mawoo.tradescript.service.controllers;

import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import nl.mawoo.tradescript.service.workspace.ReloadWorkspaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refresh")
public class Refresh {
    @Autowired
    private ScriptDao scriptDao;

    @RequestMapping("/reset")
    public boolean refreshWorkspace() {
        ReloadWorkspaces reloadWorkspaces = new ReloadWorkspaces("/home/bobvdvalk/workspace/", scriptDao);
        return reloadWorkspaces.reset();
    }

    @RequestMapping("/update")
    public Iterable<Script> update() {
        ReloadWorkspaces reloadWorkspaces = new ReloadWorkspaces("/home/bobvdvalk/workspace/", scriptDao);
        return reloadWorkspaces.update();
    }
}
