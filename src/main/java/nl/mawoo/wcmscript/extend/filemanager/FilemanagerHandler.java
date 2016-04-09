package nl.mawoo.wcmscript.extend.filemanager;

import nl.mawoo.wcmscript.extend.filemanager.scanner.Scanner;
import nl.mawoo.wcmscript.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FilemanagerHandler {

    private Logger logger = Logger.getLogger(FilemanagerHandler.class.getName());

    /**
     * Lists all the files in a directory
     * @param directoryPath Path to the directory.
     */
    public List<File> listFiles(String directoryPath) {
        return new ArrayList<>(Arrays.asList(new File(directoryPath).listFiles()));
    }

    /**
     * List all the files in a directory with a certain extension.
     * @param directoryPath Path to the directory.
     * @param extensions  The extension of the files listed.
     * @return Returns a list of files in the parent directory
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
     * @return Returns a list of Directories which are found in the parent directory
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
            logger.error("Can\'t get BasicFileAttributes. "+ e);
        }
        return null;
    }

    /**
     * Scans all the folders and files derived from the parent directory.
     * @param scanner Scanner class
     * @param directory Path to the parent directory.
     * @param bufferSize Buffer size
     * @param threads Worker thread amount
     * @return Returns a HashMap containing the File path(e.g : C:/Windows/virus.bat) as the key and the data as the value.
     */
    public ConcurrentHashMap<String, String> scanFiles(Class<? extends FileScannerWorker> scanner, String directory, int bufferSize, int threads) throws InterruptedException {
        return new Scanner(scanner, bufferSize, threads).scan(directory);
    }


    /**
     * Creates files for testing purposes !BE CAREFUL USING THIS FUNCTION!
     * @param parentDirectory Parent directory where the files will be created in.
     * @param amount Amount of files to be created.
     */
    public void createFiles(String parentDirectory, int amount) {
            try {
                for(int i = 1; i <= amount; i++) {
                    Files.createFile(Paths.get(parentDirectory + i + ".txt"));
                }
            } catch (IOException e) {
                logger.error("Can\'t create files. "+ e);
        }

    }

    /**
     * Returns the value of a tag found in the metadata
     * @param data List of metadata retrieved from the Scanner
     * @param tag The tag of which the value has to be returned
     * @return The value of the tag
     */
    public String getMetaDataTag(String data, String tag) {
        String[] list = data.split(", ");
        for(String s : list) {
            String[] temp = s.split("=");
            if(temp[0].equalsIgnoreCase(tag)) {
                return temp[1];
            }
        }
        return "";
    }
}
