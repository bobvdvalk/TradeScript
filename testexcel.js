use("exceloutput.js");

print("Creating a excelfile");

var output = new ExcelOutput("testsheet");

var rownum = 0;

for(i = 0; i < 10; i++){
    output.addRow(rownum);
    rownum++;

    output.createCell("Hello", 0);
    output.createCell("World!", 1);
}

output.save("workbook.xlsx");
