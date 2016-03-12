use("filemanager.js");
var fm = FileManager.getFileManager();

//print(FileManager.getFileManagerHandler().listFiles("F:/test"));

//var list = Java.type("java.util.List");
var list = FileManager.listFiles("F:/test"); // list all the files in a directory
list = FileManager.getFileManagerHandler().getNestedFiles("F:/test");
for(j = 0; j < list.size(); j++) {
   // expandDirectory(list.get(j))
    print(list.get(j));
}

/*
for(i = 0; i < list.size(); i++) { //loop through all the files found in the parent directory
    print("File: "+list.get(i).getAbsolutePath()); //print the file's absolute path
    print("Owner: "+fm.getOwner(FileManager.getPath(list.get(i).getAbsolutePath()))); // print the file's owner
    print("Metadata: "+fm.readAttributes(FileManager.getPath(list.get(i).getAbsolutePath()), "*")); // print the metadata of the file
}
*/
var file = Java.type("java.io.File");
//expandDirectory(new file("F:/test"));
function expandDirectory(parent) {
    var files = FileManager.listFiles((""+parent.getAbsolutePath()).replace("\\", "/"));
    //print("list: "+files);
    for(i = 0; i < files.size(); i++) {
        print(files.get(i));
        if(files.get(i).isDirectory()) {
            expandDirectory(files.get(i));
        }
        //print("i is: "+i);
    }
}


//var data = FileManager.getFileManagerHandler().getBasicFileAttributes();