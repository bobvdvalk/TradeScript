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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * This class is responsible to read/import excel files
 * TODO: There has to be a way to intergrate this better into WCMScript
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

    /**
     * This method is responsible to open the right sheet
     * @param name the name of the sheet you want to read
     * @return this for chaining, read rows, cells, etc
     */
    public ExcelImportV2 getSheet(String name) {
        sheet = workbook.getSheet(name);
        return this;
    }

    /**
     * Returns for iterator so you can "scan" the excel sheet
     * @return iterator of rows from the excel sheet
     */
    public Iterator<Row> rowIterator() {
        return sheet.rowIterator();
    }

    /**
     * testing method
     * TODO: complete this method to show everything to make it easier.
     */
    public void showEverything() {

    }

    /**
     * Close everything (workbook & inputStream
     */
    public void close() {
        try {
            inputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
