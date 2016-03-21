package nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Joshua on 21/03/2016.
 */
public abstract class ProcessResultWorker implements Runnable {

    protected LinkedBlockingQueue data;

    public ProcessResultWorker(LinkedBlockingQueue data) {
        this.data = data;
    }

    @Override
    public abstract void run();

    public LinkedBlockingQueue getData() {
        return data;
    }
}
