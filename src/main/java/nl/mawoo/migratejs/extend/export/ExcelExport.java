package nl.mawoo.migratejs.extend.export;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class is responible to export data to Excel .
 *
 * @author Bob van der Valk
 */
public class ExcelExport {

    public ExcelExport(String filename) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream fileOut = new FileOutputStream(new File(filename));

            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
