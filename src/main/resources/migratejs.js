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