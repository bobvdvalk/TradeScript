package nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Joshua on 15/03/2016.
 */
public abstract class FileScannerWorker implements Runnable {

    /*
     * Variables inits
     */
    protected BlockingQueue<File> queue;
    protected HashMap<File, String> output;

    public FileScannerWorker(BlockingQueue<File> queue, HashMap<File, String> output) {
        this.queue = queue;
        this.output = output;
    }

    /**
     * Run method used by threads.
     */
    @Override
    public abstract void run();

    public BlockingQueue<File> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    public HashMap<File, String> getOutput() {
        return output;
    }

    public void setOutput(HashMap<File, String> output) {
        this.output = output;
    }
}
