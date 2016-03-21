package nl.mawoo.migratejs.extend.filemanager.scanner;

import nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Joshua on 15/03/2016.
 */
public class Scanner {

    int queueBuffer = 10000000;
    int workerCount = 10;
    BlockingQueue<File> queue;
    Class<FileScannerWorker> scanner;

    /**
     * Scanner constructor
     * @param scanner Class of a scanner worker extending FileScannerWorker
     */
    public Scanner(Class<? extends FileScannerWorker> scanner) {
        queue = new ArrayBlockingQueue<File>(queueBuffer);
        this.scanner = (Class<FileScannerWorker>) scanner;
    }

    /**
     * Scanner constructor
     * @param scanner Class of a scanner worker extending FileScannerWorker
     * @param queueBuffer Size of the queue buffer.
     */
    public Scanner(Class<? extends FileScannerWorker> scanner, int queueBuffer) {
        this(scanner);
        this.queueBuffer=queueBuffer;
    }

    /**
     * Scanner constructor
     * @param scanner Class of a scanner worker extending FileScannerWorker
     * @param queueBuffer Size of the queue buffer.
     * @param workerCount Worker Thread count
     */
    public Scanner(Class<? extends FileScannerWorker> scanner, int queueBuffer, int workerCount) {
        this(scanner, queueBuffer);
        this.workerCount = workerCount;
    }

    /**
     * Scan a parent directory.
     * @param directory Parent directory.
     * @return
     */
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
        List<File> keysAsArray = new ArrayList<File>(output.keySet());
        for(int i = 0; i < 10; i++) {
            int rand = new Random().nextInt(keysAsArray.size());
            System.out.println("File: " + keysAsArray.get(rand) + " data: " + output.get(keysAsArray.get(rand)));
        }
        return output;
    }

    /**
     * Creats a list of ListScannerWorker extends
     * @param fileData
     * @return
     */
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

    private void processResult() {

    }

    private void initParentDir(String directory) {
        try {
            queue.put(new File(directory));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
