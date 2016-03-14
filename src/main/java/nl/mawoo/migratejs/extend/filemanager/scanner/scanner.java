package nl.mawoo.migratejs.extend.filemanager.scanner;

import nl.mawoo.migratejs.extend.filemanager.scanner.workers.FileAttributeScanner;
import nl.mawoo.migratejs.extend.filemanager.scanner.workers.FileEnumerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Joshua on 13-3-2016.
 */
public class Scanner {
    String directory;
    String attributes;

    final int QUEUE_SIZE = 10;
    final int DIR_QUEUE_SIZE = 1000;
    int SCAN_THREADS = 1;
    int DIR_SCAN_THREADS = 2000;

    BlockingQueue<File> queue;
    BlockingQueue<File> directoryQueue;

    public Scanner(String directory) {
        this.directory = directory;
        //this.attributes = attributes;
        queue = new ArrayBlockingQueue<File>(QUEUE_SIZE);
        directoryQueue = new ArrayBlockingQueue<File>(DIR_QUEUE_SIZE);

    }
    public Scanner(String directory, int SCAN_THREADS) {
        this.directory = directory;
        this.SCAN_THREADS = SCAN_THREADS;
        //this.attributes = attributes;
        queue = new ArrayBlockingQueue<File>(QUEUE_SIZE);
        directoryQueue = new ArrayBlockingQueue<File>(DIR_QUEUE_SIZE);
    }

    public HashMap<File, String> scan(int threads) {
        HashMap<File, String> output = new HashMap<>();
        DIR_SCAN_THREADS = threads;
        /*
            Put in the first Directory
         */
        try {
            directoryQueue.put(new File(directory));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Thread> threadsList = new ArrayList<>();
        for(int i = 0; i < DIR_SCAN_THREADS; i++) {
            threadsList.add(new Thread(new FileEnumerator(queue, directoryQueue)));
        }
        for(int i = 0; i < SCAN_THREADS; i++) {
            threadsList.add(new Thread(new FileAttributeScanner(output,queue)));
        }
        for(Thread t : threadsList) {
            t.start();
        }
        for(Thread t: threadsList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return output;
    }
}
