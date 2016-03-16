package nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Joshua on 15/03/2016.
 */
public abstract class FileScannerWorker implements Runnable {

    /*
     * Variables inits
     */
    protected BlockingQueue<File> queue;
    protected ConcurrentHashMap<File, String> output;

    public FileScannerWorker(BlockingQueue<File> queue, ConcurrentHashMap<File, String> output) {
        this.queue = queue;
        this.output = output;
    }

    /**
     * Run method used by threads.
     */
    @Override
    public abstract void run();

    /**
     * The File Scan buffer
     * @return
     */
    public BlockingQueue<File> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    /**
     * Output HashMap with file data
     * @return
     */
    public ConcurrentHashMap<File, String> getOutput() {
        return output;
    }

    public void setOutput(ConcurrentHashMap<File, String> output) {
        this.output = output;
    }
}
