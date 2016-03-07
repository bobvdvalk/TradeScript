FileManager = {

    /**
     * This method is used to retrieve an object of the FilemanagerHandler class used to perform managing functions on the file system.
     * @returns {FileManagerClass} FileManagerHandler object.
     */
    getFileManager: function() {
        var fileManagerClass = Java.type("nl.mawoo.migratejs.extend.filemanager.FilemanagerHandler");
        return new FileManagerClass();
    }
}