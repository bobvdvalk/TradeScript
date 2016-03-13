package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Joshua on 13-3-2016.
 */
public class FileEnumerator implements Runnable{
    BlockingQueue<File> queue;
    BlockingQueue<File> dirQueue;

    public FileEnumerator(BlockingQueue<File> queue, BlockingQueue<File> dirQueue) {
        this.queue = queue;
        this.dirQueue = dirQueue;
    }

    @Override
    public void run() {
            boolean run = true;
            while (run) {
                try {
                    File f = dirQueue.poll(75, TimeUnit.MILLISECONDS);
                    if(f == null) {
                        run = false;
                    } else {
                        expand(f);
                    }
                } catch (InterruptedException e) {
                    run = false;
                    e.printStackTrace();
                }
            }
    }

    public void expand(File dir) throws InterruptedException {
        if(dir != null) {
            File[] files = dir.listFiles();
            for(File f : files) {
                if (f.isDirectory())
                    dirQueue.put(f);
                else
                    queue.put(f);
            }
        }
    }
}
