package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

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

            boolean end = false;
            while (!end) {
                try {
                    File f = queue.poll(100, TimeUnit.MILLISECONDS);
                    try {
                        if(f !=null) {
                            output.put(f, Files.readAttributes(Paths.get(f.getAbsolutePath()), "*").toString());
                        } else {
                                end = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
}
