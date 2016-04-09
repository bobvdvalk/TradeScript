/**
 * Create a blank excel page
 * @param sheetname name you want to give to the spreadsheet.
 */
var ExcelOutput = function(sheetname) {
  var excelClass = Java.type("nl.mawoo.wcmscript.extend.export.ExcelExport");
  this.excelExport = new excelClass(sheetname);
};
    /**
     * Add row to the spreadsheet.
     * @param rowNumber number of the row you want to use to add cells.
     */
    ExcelOutput.prototype.addRow = function(rowNumber) {
        this.excelExport.addRow(rowNumber);
    };
    /**
     * Create a cell into the spreadsheet.
     * @param input content you want to give to the cell
     * @param cellnum cell number on the row.
     */
    ExcelOutput.prototype.createCell = function(input, cellnum) {
        this.excelExport.createCell(input, cellnum);
    };
    /**
     * Save the excel sheet to your location
     * @param filename name of the file you want to set.
     */
    ExcelOutput.prototype.save = function(filename) {
        this.excelExport.save(filename);
    };