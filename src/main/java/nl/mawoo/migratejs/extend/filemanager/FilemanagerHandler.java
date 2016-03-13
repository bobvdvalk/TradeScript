package nl.mawoo.migratejs.extend.filemanager;

import nl.mawoo.migratejs.converter.JsonConverter;
import nl.mawoo.migratejs.extend.filemanager.scanner.Scanner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

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
        return jc.listConverter(Arrays.asList(new File(directoryPath).listFiles()));
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

    public List<File> getNestedFiles(String path) {
        List<File> output = new ArrayList<File>();
        expandDirectory(new File(path), output);
        return output;
    }

    /**
     * Used to enumerate through directories.
     * @param f parent file
     * @param output list of all files.
     */
    private void expandDirectory(File f, List<File> output) {
        List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        output.addAll(files);
        for(File file : files) {
            if(file.isDirectory()) {
                expandDirectory(file, output);
            }
        }
    }

    public HashMap<File, String> scanFiles(String directory, int threads) {
        return new Scanner(directory).scan(threads);
    }


    public void createFiles(String parentDirectory, int amount) {
            try {
                for(int i = 1; i <= amount; i++) {
                    Files.createFile(Paths.get(parentDirectory + i + ".txt"));
                }
            } catch (IOException e) {
                e.printStackTrace();
        }

    }


}
