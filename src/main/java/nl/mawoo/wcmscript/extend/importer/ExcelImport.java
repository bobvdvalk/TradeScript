package nl.mawoo.wcmscript.extend.importer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Joshua on 24-3-2016.
 */
public class ExcelImport {

    private XSSFWorkbook workbook;

    public ExcelImport(String path) {
        File f = new File(path);
        try {
            this.workbook = new XSSFWorkbook(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private XSSFSheet getSheet(String name) {
        return workbook.getSheet(name);
    }

    /**
     * Gets the iterator holding all the rows of a given sheet
     * @param sheet Sheet which the rows iterator is return from
     * @return Iterator with all the rows from the given sheet
     */
    private Iterator<Row> getRowIterator(XSSFSheet sheet) {
        return sheet.iterator();
    }

    /**
     * Get the iterator to all the cells in the given Row
     * @param row Row from which the cells iterator is returned
     * @return Iterator with all the cells of the given row
     */
    private Iterator<Cell> getCellIterator(Row row) {
        return row.iterator();
    }

    public List<Row> getRows(XSSFSheet sheet) {
        List<Row> output = new ArrayList<>();
        Iterator<Row> rows = getRowIterator(sheet);
        while(rows.hasNext()) {
            output.add(rows.next());
        }
        return output;
    }

    /**
     * Returns a hashmap containing the cell adresses and their objects from a certain sheet
     * @param sheet Excel sheet the cells are on
     * @return A HashMap containing all the adresses as keys, and cells as values respectively.
     */
    public HashMap<String,Cell> getCells(XSSFSheet sheet) {
        HashMap<String, Cell> output = new HashMap<>();
        Iterator<Row> rows = getRowIterator(sheet);
        while(rows.hasNext()) {
            Iterator<Cell> cells = getCellIterator(rows.next());
            while(cells.hasNext()) {
                Cell c = cells.next();
                output.put(c.getAddress().formatAsString(),c);
            }
        }
        return output;
    }

    /**
     * Retrieves a Cell object from a certain adress on a certain sheet
     * @param sheet Excel sheet the cell is on
     * @param address Address of the cell E.G: A1
     * @return Cell which is found on the address
     */
    public Cell getCell(XSSFSheet sheet, String address) {

        CellReference ref = new CellReference(address);
        Row r = sheet.getRow(ref.getRow());
        if (r != null) {
            return r.getCell(ref.getCol());
        } else {
            return null;
        }
    }

    /**
     * Retrieves the (calculated) value of a certain cell as a String.
     * @param sheet Excel sheet the cell is on
     * @param address Adress of the cell E.G: A1
     * @return Returns the cell value as a String
     */
    public String getCellValue(XSSFSheet sheet, String address) {
        CellReference ref = new CellReference(address);
        Row r = sheet.getRow(ref.getRow());
            if (r != null) {
                DataFormatter df = new DataFormatter();
                Cell cell = r.getCell(ref.getCol());
                if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                    switch (cell.getCachedFormulaResultType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            return String.valueOf(cell.getNumericCellValue());
                        case Cell.CELL_TYPE_STRING:
                            return cell.getStringCellValue();
                    }
                } else {
                    return cell.toString();
                }
        }
        return null;
    }
}
