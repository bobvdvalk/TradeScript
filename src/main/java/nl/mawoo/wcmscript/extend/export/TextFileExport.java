package nl.mawoo.wcmscript.extend.export;

import nl.mawoo.wcmscript.logger.AbstractLogger;
import nl.mawoo.wcmscript.logger.WCMSLogger;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible to export to a file
 *
 * @author Bob van der Valk
 */
public class TextFileExport {
    private Object content;
    private File file;

    private AbstractLogger logger = WCMSLogger.getLogger(TextFileExport.class);

    /**
     * Instance a new file
     * @param filename name & location of the file you want.
     * @param content content you want to give to the file
     */
    public TextFileExport(String filename, Object content) {
        this.content = content;
        file = new File(filename);
    }

    /**
     * Save a new file. With any content you want.
     *
     * @throws IOException When a file can't write or save
     */
    public void save() {
        try {

            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);

            bw.write((String) content);
            bw.close();

        } catch (IOException e) {
            logger.error("Cannot creat file "+ e);
        }

    }

}
