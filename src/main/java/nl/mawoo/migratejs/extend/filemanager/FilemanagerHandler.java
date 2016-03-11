package nl.mawoo.migratejs.extend.filemanager;

import nl.mawoo.migratejs.converter.JsonConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Joshua on 5-3-2016.
 */
public class FilemanagerHandler {

    /**
     * Lists all the files in a directory
     * @param directoryPath Path to the directory.
     */
    public List<File> listFiles(String directoryPath) {
        return new ArrayList<File>(Arrays.asList(new File(directoryPath).listFiles()));
    }

    public String listFilesString(String directoryPath) {
        JsonConverter jc = new JsonConverter();
        return jc.listToJson(Arrays.asList(new File(directoryPath).listFiles()));
    }

    /**
     * List all the files in a directory with a certain extension.
     * @param directoryPath Path to the directory.
     * @param extensions  The extension of the files listed.
     * @return
     */
    public List<File> listFiles(String directoryPath, String extensions) {
        List<File> output = new ArrayList<>();
        String extensionList[] = extensions.replaceAll("[ .]", "").split(",");
        for(File f : new File(directoryPath).listFiles()) {
            for(String extension : extensionList) {
                if (f.getName().endsWith(extension)) {
                    output.add(f);
                    continue;
                }
            }
        }
        return output;
    }

    /**
     * Lists all the directories in a directory.
     * @param directoryPath Path to the directory.
     * @return
     */
    public List<File> listDirectories(String directoryPath) {
        List<File> output = new ArrayList<>();
        for(File file : new File(directoryPath).listFiles()) {
            if(file.isDirectory())
                output.add(file);
        }
        return output;
    }

    /**
     * Returns a BasicFileAttributes object which holds metadata of a file.
     * @param path String to the path of the file.
     * @return BasicFileAttributes object
     */
    public BasicFileAttributes getBasicFileAttributes(String path) {
        try {
            return Files.readAttributes(Paths.get(path), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
