package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import nl.mawoo.migratejs.extend.filemanager.scanner.Scanner;
import nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Joshua on 15/03/2016.
 */
public class MetadataFileScanner extends FileScannerWorker {

    int i = new Random().nextInt(1000);

    public MetadataFileScanner(BlockingQueue<File> queue, ConcurrentHashMap<File, String> output) {
        super(queue, output);
       // System.out.println("Created thread");
    }


    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                File f = this.queue.poll(25, TimeUnit.MILLISECONDS);
                if(f != null) {
                    if(f.isDirectory()) {
                        File[] files = f.listFiles();
                        for(File file : files) {
                            //System.out.println("Adding file: "+file);
                            this.queue.add(file);
                        }
                    } else {
                        try {
                            output.put(f, String.valueOf(Files.readAttributes(Paths.get(f.getAbsolutePath()),"*")));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    run = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
