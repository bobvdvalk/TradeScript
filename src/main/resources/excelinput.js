/**
 * Created by Joshua on 25-3-2016.
 */

var ExcelImput = function(filename) {
    var excelClass = Java.type("nl.mawoo.wcmscript.extend.importer.ExcelImport");
    this.excelImput = new excelClass(filename);
};

ExcelImput.prototype.getCell = function(sheet, adress) {
    return this.excelImput.getCell(this.excelImput.getSheet(sheet), adress);
}
ExcelImput.prototype.getCellValue = function(sheet, adress) {
    return this.excelImput.getCellValue(this.excelImput.getSheet(sheet), adress);
}

ExcelImput.prototype.getAllCells = function(sheet) {
    return this.excelImput.getCells(this.excelImput.getSheet(sheet));
}

