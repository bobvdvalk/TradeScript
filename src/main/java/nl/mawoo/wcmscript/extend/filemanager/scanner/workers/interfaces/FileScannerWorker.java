package nl.mawoo.wcmscript.extend.filemanager.scanner.workers.interfaces;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  FileScannerWorker which is used in scanning files and retrieving some sort of data from them.
 *  This class is used to create the actual workers.
 */
public abstract class FileScannerWorker implements Runnable {

    /*
     * Variables inits
     */
    protected BlockingQueue<File> queue;
    protected ConcurrentHashMap<String, String> output;

    /**
     * FileScannerWorker constructor
     * @param queue Listed files queue
     * @param output Output HashMap
     */
    public FileScannerWorker(BlockingQueue<File> queue, ConcurrentHashMap<String, String> output) {
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
     * @return Returns the listed files queue
     */
    public BlockingQueue<File> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    /**
     * Output HashMap with file data
     * @return Returns the HashMap with the file data
     */
    public ConcurrentHashMap<String, String> getOutput() {
        return output;
    }

    public void setOutput(ConcurrentHashMap<String, String> output) {
        this.output = output;
    }

}
