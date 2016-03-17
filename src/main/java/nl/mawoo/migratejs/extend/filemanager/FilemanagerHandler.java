package nl.mawoo.migratejs.extend.filemanager;

import nl.mawoo.migratejs.converter.JsonConverter;
import nl.mawoo.migratejs.extend.filemanager.scanner.Scanner;
import nl.mawoo.migratejs.extend.filemanager.scanner.workers.MetadataFileScanner;
import nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    public HashMap<File, String> getNestedFiles(String path) {
        HashMap<File, String> output = new HashMap<File, String>();
        expandDirectory(new File(path), output);
        return output;
    }

    /**
     * Used to enumerate through directories.
     * @param f parent file
     * @param output list of all files.
     */
    private void expandDirectory(File f, HashMap<File, String> output) {
        try {
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(f.getAbsolutePath()));
            for(Path p : stream) {
                File file = p.toFile();
                if(file.isDirectory()) {
                    expandDirectory(file, output);
                } else {
                    output.put(file, String.valueOf(Files.readAttributes(file.toPath(),"*")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Scans all the folders and files derived from the parent directory.
     * @param scanner Scanner class
     * @param directory Path to the parent directory.
     * @param bufferSize Buffer size
     * @param threads Worker thread amount
     * @return
     */
    public ConcurrentHashMap<File, String> scanFiles(Class<? extends FileScannerWorker> scanner, String directory, int bufferSize, int threads) {
        return new Scanner(scanner, bufferSize,threads).scan(directory);
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
                e.printStackTrace();
        }

    }
}
