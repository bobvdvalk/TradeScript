/**
 * Create a blank excel page
 * @param filename name you want to give to the file.
 */
var ExcelOutput = function(filename) {
  var excelClass = Java.type("nl.mawoo.migratejs.extend.export.ExcelExport");
  this.output = new excelClass(filename);
};