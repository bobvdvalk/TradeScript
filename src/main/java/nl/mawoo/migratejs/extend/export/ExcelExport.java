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

    /**
     * Create a excel sheet
     * @param name sheet name
     */
    public ExcelExport(String name) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(name);
    }

    /**
     * Create a excel sheet
     * ** Without a sheet name**
     */
    public ExcelExport() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
    }

    /**
     * Add row to excelsheet
     * @param rownum row number of sheet
     */
    public void addRow(int rownum) {
        row = sheet.createRow(rownum);
    }

    /**
     * Add cell with content to sheet
     * @param input string of information you want to put in the excel sheet
     * @param cellnum cell number you want to set for the sheet.
     */
    public void createCell(String input, int cellnum) {
        Cell cell = row.createCell(cellnum);
        cell.setCellValue(input);
    }

    /**
     * Save the excelsheet to a file
     * @param filename name you want to give to the document
     */
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
