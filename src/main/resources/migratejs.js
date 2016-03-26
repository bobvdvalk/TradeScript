/**
 * Load a js file into the program.
 * @param path path to the file to import.
 */
function include(path) {
    load(path);
}
/**
 * Use a library from the migrateJS resources
 * @param library file you want to use
 */
var use = function(library) {
    var useResource = Java.type("nl.mawoo.migratejs.resources.Resources");
    var resources = new useResource();

    load(resources.use(library));
};

/**
 * Replace all occurences in a string.
 * @param search
 * @param replacement
 * @returns {string}
 */
String.prototype.replaceAll = function(search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};