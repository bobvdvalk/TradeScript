/**
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.mawoo.wcmscript.modules.excel;

import nl.mawoo.wcmscript.AbstractScriptModule;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * This class is responsible to read excel files and put it in a object.
 *
 * @author Joshua Jenster
 */
public class ExcelImportV1 extends AbstractScriptModule {
    private XSSFWorkbook workbook;

    public ExcelImportV1 read(String path) throws IOException {
        File f = new File(path);

        try {
            this.workbook = new XSSFWorkbook(f);
        } catch (InvalidFormatException e) {
            getScriptLogger().error("This is not a excel file: " + e.getMessage());
        }

        return this;
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
    public Map<String,Cell> getCells(XSSFSheet sheet) {
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
            Cell cell = r.getCell(ref.getCol());
            if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                switch (cell.getCachedFormulaResultType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        return String.valueOf(cell.getNumericCellValue());
                    case Cell.CELL_TYPE_STRING:
                        return cell.getStringCellValue();
                    default:
                        getScriptLogger().error("Error selecting cells");
                }
            } else {
                return cell.toString();
            }
        }
        return null;
    }
}
