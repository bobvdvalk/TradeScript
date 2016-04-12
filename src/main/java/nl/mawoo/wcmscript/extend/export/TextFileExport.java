package nl.mawoo.wcmscript.extend.export;

import com.sun.istack.internal.logging.Logger;

/**
 * This class is responsible to export to a file
 *
 * @author Bob van der Valk
 */
public class TextFileExport {
    private String filename;
    private String content;

    private Logger logger = Logger.getLogger(TextFileExport.class);

    public TextFileExport(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    
}
