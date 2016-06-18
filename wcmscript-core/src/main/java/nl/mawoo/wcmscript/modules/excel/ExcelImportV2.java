package nl.mawoo.wcmscript.modules.excel;

import nl.mawoo.wcmscript.AbstractScriptModule;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is responsible to read/import excel files
 *
 * @author Bob van der Valk
 */
public class ExcelImportV2 extends AbstractScriptModule {
    private FileInputStream inputStream;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    /**
     * This method opens a XLXS (excel file) and puts it in a stream so the XSSF library can read the sheet
     * @param path location of the file
     * @return this for chaining
     */
    public ExcelImportV2 open(String path) {
        try {
            File file = new File(path);
            inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);

            return this;
        } catch (FileNotFoundException e) {
            getScriptLogger().error("Can\'t open the selected file in path");
        } catch (IOException e) {
            getScriptLogger().error("Can\'t open the workbook from selected file");
        }

        return null;
    }

}
