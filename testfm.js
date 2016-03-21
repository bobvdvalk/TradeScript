use("filemanager.js");
print("start");

var time1 = new Date().getTime();

var test = FileManager.scanFiles(FileManager.scanners.METADATA, "C:/Coding", 0, 10);
//var test = FileManager.getFileManagerHandler().getNestedFiles("F:/Feed The Beast/");

var time2 = new Date().getTime();
print("time2: "+(time2-time1));
print("Size2 is: " + test.size());

