package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Joshua on 13-3-2016.
 */
public class FileAttributeScanner implements Runnable {
    HashMap<File, String> output;
    BlockingQueue<File> queue;

    public FileAttributeScanner(HashMap<File, String> output, BlockingQueue<File> queue) {
        this.output = output;
        this.queue = queue;
        //System.out.println("Created FileAttributeScanner!");
    }


    @Override
    public void run() {
        //System.out.println("Started FileAttributeScanner!");
        try {
            boolean end = false;
            while (!end) {
                File f = queue.take();
                if(f != FileEnumerator.terminationFile) {
                    try {
                        output.put(f, Files.readAttributes(Paths.get(f.getAbsolutePath()),"*").toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    queue.put(f);
                    end = true;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
