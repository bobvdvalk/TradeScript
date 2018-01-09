package nl.mawoo.tradescript.service.services;

import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import nl.mawoo.tradescript.service.storage.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.exit;

@Component
public class Workspace {
    private static final Logger LOGGER = LoggerFactory.getLogger(Workspace.class);

    @Autowired
    private ScriptDao scriptDao;

    private String folder;
    private List<Script> scripts = new ArrayList<>();

    public Workspace(String folder) {
        this.folder = folder;
    }

    public void scanWorkspace() {
        this.getScriptsFromFolder();
        LOGGER.info("I found these scripts:");
        for (Script script : scripts) {
            LOGGER.info(script.getFilename() + " - " + script.getStatus().toString());
        }
    }

    /**
     * Get all scripts from the current workspace and load them into a list
     */
    private void getScriptsFromFolder() {
        List<File> filesInFolder = null;
        try {
            filesInFolder = Files.walk(Paths.get(this.folder))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            for (File file : filesInFolder) {
                if (this.getFileExtension(file).equals("trd")) {
                    Script script = new Script(file.getName(), file.getPath(), Status.SEEN);
                    scripts.add(script);
                    scriptDao.save(script);
                }
            }
        } catch (IOException e) {
            LOGGER.error("Something went wrong searching the workspace" + e);
            LOGGER.error("Exiting because this program does not work without a workspace.");
            exit(-1);
        }
    }

    public String getFolder() {
        return folder;
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
