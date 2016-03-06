/**
 * Return a test message (Hello World);
 * @returns {string}
 */
function TestMessage() {
    var testClass = Java.type("nl.mawoo.migratejs.extend.Test");
    var test = new testClass();
    print(test.Message())
}

/**
 * Load a js file into the program.
 * @param path path to the file to import.
 */
function include(path) {
    load(path);
}

var use = function(library) {
    var useResource = Java.type("nl.mawoo.migratejs.resources.Resources");
    var resources = new useResource();

    load(resources.use(library));
};