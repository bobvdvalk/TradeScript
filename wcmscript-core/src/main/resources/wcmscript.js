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
var use = function (library) {
    try {
        System.loadModule(library);
    } catch (e) {
        print("Could not load library [" + library + "]");
        print("Reason: " + e.message);
    }
};

/**
 * Print a message in the console with the logger.
 * @param message String of input
 */
function print(message) {
    Logger.info(message);
}

function debug(message) {
    Logger.debug(message);
}

function info(message) {
    Logger.info(message);
}

function warn(message) {
    Logger.warn(message);
}

function error(message) {
    Logger.error(message);
}


/**
 * Replace all occurences in a string.
 * @param search
 * @param replacement
 * @returns {string}
 */
String.prototype.replaceAll = function (search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};