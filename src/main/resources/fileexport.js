var FileExport = function(filename, content) {
    var exportClass = Java.type("nl.mawoo.wcmscript.extend.export.TextFileExport");

    this.fileExport = new exportClass(filename, content);
};

    FileExport.prototype.save = function() {
        this.fileExport.save();
    };