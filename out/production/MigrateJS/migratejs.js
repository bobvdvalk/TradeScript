/**
 * Return a test message (Hello World);
 * @returns {string}
 */
var TestMessage = function() {
    var testClass = Java.type("nl.mawoo.migratejs.extend.Test");

    print(testClass.Message())
}

/**
 * Load a js file into the program.
 * @param path path to the file to import.
 */
function include(path) {
    var includeClass = Java.type("nl.mawoo.migratejs.extend.Include");

    includeClass.load(path);
}

function includeTest(path) {
    var includeClass = Java.type("nl.mawoo.migratejs.extend.Include");

    print(includeClass.test());
}