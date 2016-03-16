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

var test = FileManager.getFileManagerHandler().scanFiles("D:/Games/",0);

var time2 = new Date().getTime();
print("time: "+(time2-time1));
print("Size is: " + test.size());