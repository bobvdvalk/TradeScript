/**
 * Connect to a MongoDB Library
 * @constructor
 */
var MongoConnector = function(database) {
    var mongoClass = Java.type("nl.mawoo.wcmscript.extend.dbconnector.MongoConnector");
    return new mongoClass(database);
};

