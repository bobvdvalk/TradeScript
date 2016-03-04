/**
 * Return a test message (Hello World);
 * @returns {string}
 */
var TestMessage = function() {
    var testClass = Java.type("nl.mawoo.migratejs.extend.Test");
    var test = new testClass();
    print(test.Message())
}

/**
 * Load a js file into the program.
 * @param path path to the file to import.
 */
function include(path) {
    var includeClass = Java.type("nl.mawoo.migratejs.extend.Include");
    var include = new includeClass();

    include.load(path);
}

function includeTest(path) {
    var includeClass = Java.type("nl.mawoo.migratejs.extend.Include");

    print(includeClass.test());
}