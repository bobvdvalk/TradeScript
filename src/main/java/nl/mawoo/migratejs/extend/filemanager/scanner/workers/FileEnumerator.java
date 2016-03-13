package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Joshua on 13-3-2016.
 */
public class FileEnumerator implements Runnable{
    BlockingQueue<File> queue;
    File parentDir;
    public static File terminationFile = new File("1337");

    public FileEnumerator(BlockingQueue<File> queue, File parentDir) {
        this.queue = queue;
        this.parentDir = parentDir;
    }

    @Override
    public void run() {
        try {
            long m1 = System.currentTimeMillis();
            System.out.println("Starting file search");
            expand(parentDir);
            queue.put(terminationFile);
            System.out.println("End file search, took "+(System.currentTimeMillis()-m1)+" ms.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void expand(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for(File f : files) {
            if(f.isDirectory())
                expand(f);
            else
                queue.put(f);
        }
    }
}
