package nl.mawoo.migratejs.extend.export;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * This class is responible to export data to Excel .
 *
 * @author Bob van der Valk
 */
public class ExcelExport {
    private FileOutputStream fileOut;
    private XSSFWorkbook workbook;
    private XSSFSheet spreadsheet;

    public ExcelExport(String name) {
        workbook = new XSSFWorkbook();
        spreadsheet = workbook.createSheet(name);


    }

    public ExcelExport() {
        workbook = new XSSFWorkbook();
        spreadsheet = workbook.createSheet();
    }
}
