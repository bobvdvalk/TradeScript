use("filemanager.js");
var fm = FileManager.getFileManager();

var test = FileManager.scanFiles("F:/Feed The Beast/");
print("Size is: " + test.size());