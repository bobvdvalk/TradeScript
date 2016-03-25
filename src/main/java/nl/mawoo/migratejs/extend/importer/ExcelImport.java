package nl.mawoo.migratejs.extend.importer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

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

    public XSSFSheet getSheet(String name) {
        return workbook.getSheet(name);
    }

    /**
     * Gets the iterator holding all the rows of a given sheet
     * @param sheet Sheet which the rows iterator is return from
     * @return Iterator with all the rows from the given sheet
     */
    public Iterator<Row> getRowIterator(XSSFSheet sheet) {
        return sheet.iterator();
    }

    /**
     * Get the iterator to all the cells in the given Row
     * @param row Row from which the cells iterator is returned
     * @return Iterator with all the cells of the given row
     */
    public Iterator<Cell> getCellIterator(Row row) {
        return row.iterator();
    }

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

    public Cell getCell(XSSFSheet sheet, String address) {
        CellReference ref = new CellReference(address);
        Row r = sheet.getRow(ref.getRow());
        if (r != null) {
            return r.getCell(ref.getCol());
        } else {
            return null;
        }
    }

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
