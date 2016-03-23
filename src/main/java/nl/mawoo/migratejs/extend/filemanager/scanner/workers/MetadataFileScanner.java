package nl.mawoo.migratejs.extend.filemanager.scanner.workers;

import nl.mawoo.migratejs.extend.filemanager.scanner.workers.interfaces.FileScannerWorker;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * MetadataFileScanner is an extend to FileScannerWorker object which essentially does all the scan file logic.
 * In this case the MetadataFileScanner goes through all files in the queue and retrieves the file attributes.
 * Files are taken from the queue, checked if they are a directory or an actual file. If they're a directory the files are listed
 * and put back into the queue. If they're an actual file, the attributes are read and put into the output HashMap.
 */
public class MetadataFileScanner extends FileScannerWorker {

    /**
     * metadataFileScanner constructor
     * @param queue Files queue
     * @param output Output HashMap it needs to add the file metadata to.
     */
    public MetadataFileScanner(BlockingQueue<File> queue, ConcurrentHashMap<String, String> output) {
        super(queue, output);
    }


    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                File f = this.queue.poll(20, TimeUnit.MILLISECONDS);
                if(f != null) {
                    if(f.isDirectory()) {
                        try {
                            DirectoryStream<Path> inputStream = Files.newDirectoryStream(Paths.get(f.getAbsolutePath()));
                            for(Path p : inputStream) {
                                this.queue.add(p.toFile());
                            }
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            output.put(f.getAbsolutePath(), String.valueOf(Files.readAttributes(Paths.get(f.getAbsolutePath()),"*")));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    run = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
