package nl.mawoo.migratejs.extend.filemanager.scanner;

import nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Joshua on 15/03/2016.
 */
public class Scanner {

    int queueBuffer = 50000;
    int workerCount = 10;
    BlockingQueue<File> queue;
    Class<FileScannerWorker> scanner;

    public Scanner(Class<? extends FileScannerWorker> scanner) {
        queue = new ArrayBlockingQueue<File>(queueBuffer);
        this.scanner = (Class<FileScannerWorker>) scanner;
    }

    public Scanner(Class<FileScannerWorker> scanner, int queueBuffer) {
        this(scanner);
        this.queueBuffer=queueBuffer;
    }

    public Scanner(Class<FileScannerWorker> scanner, int queueBuffer, int workerCount) {
        this(scanner, queueBuffer);
        this.workerCount = workerCount;
    }

    public ConcurrentHashMap<File, String> scan(String directory) {
        ConcurrentHashMap<File, String> output = new ConcurrentHashMap<File, String>();
        List<Thread> threads = createThreads(createWorkers(output));
        initParentDir(directory);
        for(Thread t : threads) {
            t.start();
        }
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return output;
    }

    private List<FileScannerWorker> createWorkers(ConcurrentHashMap<File, String> fileData) {
        List<FileScannerWorker> output = new ArrayList<>();
            try {
                for(int i = 0; i < workerCount; i++) {
                    output.add(scanner.getDeclaredConstructor(BlockingQueue.class, ConcurrentHashMap.class).newInstance(queue, fileData));
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        return output;
    }

    private List<Thread> createThreads(List<FileScannerWorker> workers) {
        List<Thread> output = new ArrayList<>();
        for(FileScannerWorker fsw: workers) {
            output.add(new Thread(fsw));
        }
        return output;
    }

    private void initParentDir(String directory) {
        try {
            queue.put(new File(directory));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
