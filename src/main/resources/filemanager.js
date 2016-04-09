FileManager = {

    /**
     * This method is used to retrieve an object of the FilemanagerHandler class used to perform managing functions on the file system.
     * @returns {FileManagerClass} FileManagerHandler object.
     */
    getFileManagerHandler: function() {
        var fileManagerClass = Java.type("nl.mawoo.wcmscript.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass();
    },

    /**
     * Returns a Java Files object.
     * @returns {*} Files object.
     */
    getFileManager: function() {
        var fileManagerClass = Java.type("java.nio.file.Files");
        return fileManagerClass;
    },

    /**
     * Creates a Path object using the path given.
     * @param path String representation of the path.
     * @returns {*} Java Path object.
     */
    getPath: function(path) {
        var fileManagerClass = Java.type("java.nio.file.Paths");
        return fileManagerClass.get(path);
    },

    /**
     * CopyOptions enum
     */
    copyOptions : {
        REPLACE_EXISTING: Java.type("java.nio.file.StandardCopyOption").REPLACE_EXISTING,
        COPY_ATTRIBUTES: Java.type("java.nio.file.StandardCopyOption").COPY_ATTRIBUTES,
        ATOMIC_MOVE: Java.type("java.nio.file.StandardCopyOption").ATOMIC_MOVE
    },

    /**
     * Scanner workers used by the scanner.
     */
    scanners : {
        METADATA: Java.type("nl.mawoo.wcmscript.extend.filemanager.scanner.workers.MetadataFileScanner").class
    },
    /**
     * Creates and returns a java object.
     * @param object String path to the object E.G: "java.nio.file.Files"
     * @returns {*} Object of the path given
     */
    getJavaObject: function(object) {
        return Java.type(object);
    },

    /**
     * Lists all the directories in a certain parent directory
     * @param path String path to the parent directory
     * @returns {*} Returns a Java List<file> containing all the files.
     */
    listDirectories: function(path) {
        var fileManagerClass = Java.type("nl.mawoo.wcmscript.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass().listDirectories(path);
    },

    /**
     * Lists all the files in a certain parent directory (including directories)
     * @param path String path to the parent directory
     * @returns {*} Returns a Java List<file> containing all the files.
     */
    listFiles: function(path) {
        var fileManagerClass = Java.type("nl.mawoo.wcmscript.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass().listFiles(path);
    },

    /**
     * Returns all the files that are nested in a parent directory; it will iterate through all subdirectories as well
     * @param path Path to the parent folder
     * @returns {*} Returns a Java List<file> containing all the files.
     */
    listNestedFiles: function(path) {
        var fileManagerClass = Java.type("nl.mawoo.wcmscript.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass().getNestedFiles(path);
    },

    /**
     * Scans all the folders and files derived from the parent directory.
     * @param scanner Scanner class file, accessed by using FileManager.scanners (ENUM)
     * @param path Path to the parent folder
     * @param bufferSize Size of the queue buffer.
     * @param threadAmount Amount of the worker (scanner type) threads
     * @returns {*} A HashMap<File, String> With the String holding all the metadata
     */
    scanFiles: function (scanner, path, bufferSize, threadAmount) {
        var fileManagerClass = Java.type("nl.mawoo.wcmscript.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass().scanFiles(scanner, path, bufferSize, threadAmount);
    },

    getMetaDataValue: function (metadata, tag) {
        var fileManagerClass = Java.type("nl.mawoo.wcmscript.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass().getMetaDataTag(metadata, tag);
    }


}