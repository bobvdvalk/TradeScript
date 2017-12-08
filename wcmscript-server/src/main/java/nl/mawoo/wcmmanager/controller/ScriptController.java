package nl.mawoo.wcmmanager.controller;

import nl.mawoo.wcmmanager.storage.FolderDao;
import nl.mawoo.wcmmanager.storage.ProjectDao;
import nl.mawoo.wcmmanager.storage.ScriptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ScriptController {
    @Autowired
    FolderDao folderDao;
    @Autowired
    ProjectDao projectDao;
    @Autowired
    ScriptDao scriptDao;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("projects", projectDao.findAll());
        return "ScriptManager";
    }
}
