use("filemanager.js");
var fm = FileManager.getFileManager();
var time1 = new Date().getTime();
var test = FileManager.scanFiles("D:/Games/", 3000);
var time2 = new Date().getTime();
print("time: "+(time2-time1));
print("Size is: " + test.size());