package nl.mawoo.migratejs.extend.export;

import nl.mawoo.migratejs.exceptions.CantSaveFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;

    public ExcelExport(String filename) {
        try {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet();

            FileOutputStream fileOut = new FileOutputStream(new File(filename));

            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRow(int rownum) {
        row = sheet.createRow(rownum);
    }

    public void createCell(String input, int cellnum) {
        Cell cell = row.createCell(cellnum);
        cell.setCellValue(input);
    }

    public void save(String filename) {
        try {

            FileOutputStream outputStream = new FileOutputStream(new File(filename));
            workbook.write(outputStream);
            outputStream.close();
            
        } catch (IOException e) {
            throw new CantSaveFileException("Can\'t save the excel file", e);
        }
    }
}
