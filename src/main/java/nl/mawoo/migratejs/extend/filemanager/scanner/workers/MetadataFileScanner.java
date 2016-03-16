package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Joshua on 15/03/2016.
 */
public class MetadataFileScanner extends FileScannerWorker {

    int i = new Random().nextInt(1000);

    public MetadataFileScanner(BlockingQueue<File> queue, HashMap<File, String> output) {
        super(queue, output);
       // System.out.println("Created thread");
    }


    @Override
    public void run() {
        boolean run = true;
        while (run) {
           // System.out.println("Thread: "+i+" still works");
            try {
                File f = this.queue.poll(25, TimeUnit.MILLISECONDS);
                if(f != null) {
                    System.out.println("Thread: "+i+"File: "+f.getAbsolutePath());
                    if(f.isDirectory()) {
                        File[] files = f.listFiles();
                        for(File file : files) {
                            System.out.println("added: "+file);
                           this.queue.add(file);
                        }
                    } else {
                        try {
                            output.put(f, String.valueOf(Files.readAttributes(Paths.get(f.getAbsolutePath()),"*")));
                        } catch (IOException e) {
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
