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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * This class is responsible to output a excel file
 *
 * @author Bob van der Valk
 */
public class ExcelExport extends AbstractScriptModule{
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;

    /**
     * Init a new excel file
     * @return this
     */
    public ExcelExport create() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();

        return this;
    }

    /**
     * Init a new excel file
     * @param name of the sheet
     * @return this
     */
    public ExcelExport create(String name) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(name);

        return this;
    }

    /**
     * Add row to excelsheet
     * @param rownum row number of sheet
     */
    public ExcelExport addRow(int rownum) {
        row = sheet.createRow(rownum);
        return this;
    }

    /**
     * Add cell with content to sheet
     * @param input string of information you want to put in the excel sheet.
     * @param cellnum cell number you want to set for the content.
     */
    public ExcelExport createCell(String input, int cellnum) {
        Cell cell = row.createCell(cellnum);
        cell.setCellValue(input);

        return this;
    }

    /**
     * Add cell with content to sheet
     * @param input Date you want to put in the cell.
     * @param cellnum cell number you want to set for the content.
     */
    public ExcelExport createCell(Date input, int cellnum) {
        Cell cell = row.createCell(cellnum);
        cell.setCellValue(input);

        return this;
    }

    /**
     * Add cell with content to sheet
     * @param input Boolean you want to put in the cell
     * @param cellnum cell number you want to set for the content.
     */
    public ExcelExport createCell(Boolean input, int cellnum) {
        Cell cell = row.createCell(cellnum);
        cell.setCellValue(input);

        return this;
    }

    /**
     * Add cell with content to sheet
     * @param input RichTextString you want to put in the cell
     * @param cellnum cell number you want to set for the content.
     */
    public ExcelExport createCell(RichTextString input, int cellnum) {
        Cell cell = row.createCell(cellnum);
        cell.setCellValue(input);

        return this;
    }

    /**
     * Save the excel sheet to a file
     * @param filename name you want to give to the document
     */
    public ExcelExport save(String filename) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(new File(filename));
        workbook.write(outputStream);
        outputStream.close();

        return this;
    }

}
