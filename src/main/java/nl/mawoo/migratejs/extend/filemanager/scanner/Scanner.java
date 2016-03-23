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

public class Scanner {

    int queueBuffer;
    int workerCount;
    BlockingQueue<File> queue;
    Class<FileScannerWorker> scanner;

    /**
     * Scanner constructor
     * @param scanner Class of a scanner worker extending FileScannerWorker
     * @param queueBuffer Size of the queue buffer.
     * @param workerCount Worker Thread count
     */
    public Scanner(Class<? extends FileScannerWorker> scanner, int queueBuffer, int workerCount) {
        this.queueBuffer=queueBuffer;
        this.workerCount = workerCount;
        this.scanner = (Class<FileScannerWorker>) scanner;
        queue = new ArrayBlockingQueue<>(queueBuffer);
    }

    /**
     * Scan a parent directory.
     * @param directory Parent directory.
     * @return Returns a HashMap containing the File path(e.g : C:/Windows/virus.bat) as the key and the data as the value.
     */
    public ConcurrentHashMap<String, String> scan(String directory) {
        ConcurrentHashMap<String, String> output = new ConcurrentHashMap<>();
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
        List<String> keysAsArray = new ArrayList<>(output.keySet());
        for(int i = 0; i < 10; i++) {
            int rand = new Random().nextInt(keysAsArray.size());
            System.out.println("File: " + keysAsArray.get(rand) + " data: " + output.get(keysAsArray.get(rand)));
        }
        return output;
    }

    /**
     * Creats a list of ListScannerWorker extends
     * @param fileData Output hashmap containing the files and the data
     * @return Returns a list of FileScannerWorker extended object.
     */
    private List<FileScannerWorker> createWorkers(ConcurrentHashMap<String, String> fileData) {
        List<FileScannerWorker> output = new ArrayList<>();
            try {
                for(int i = 0; i < workerCount; i++) {
                    output.add(scanner.getDeclaredConstructor(BlockingQueue.class, ConcurrentHashMap.class).newInstance(queue, fileData));
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        return output;
    }

    /**
     * Create threads based on the workers used by the scanner.
     * @param workers List of worker objects
     * @return A list of Threads
     */
    private List<Thread> createThreads(List<FileScannerWorker> workers) {
        List<Thread> output = new ArrayList<>();
        for(FileScannerWorker fsw: workers) {
            output.add(new Thread(fsw));
        }
        return output;
    }

    /**
     * Initializes the first directory.
     * @param directory Path to the parent directory.
     */
    private void initParentDir(String directory) {
        try {
            queue.put(new File(directory));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
