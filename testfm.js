use("filemanager.js");
print("start");

/*
var fm = FileManager.getFileManager();
var time1 = new Date().getTime();
var test = FileManager.scanFiles("C:/Coding/test/collection/", 10);
var time2 = new Date().getTime();
print("time: "+(time2-time1));
print("Size is: " + test.size());
*/



var time1 = new Date().getTime();

//var test = FileManager.scanFiles(FileManager.scanners.METADATA, "F:/collection", 25000, 10);
var test = FileManager.getFileManagerHandler().getNestedFiles("D:/Games");

var time2 = new Date().getTime();
print("time1: "+(time2-time1));
print("Size1 is: " + test.size());

var time1 = new Date().getTime();

var test = FileManager.scanFiles(FileManager.scanners.METADATA, "D:/Games", 0, 1);
//var test = FileManager.getFileManagerHandler().getNestedFiles("F:/Feed The Beast/");

var time2 = new Date().getTime();
print("time2: "+(time2-time1));
print("Size2 is: " + test.size());

