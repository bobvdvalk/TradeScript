/**
 * Connect to a MongoDB Library
 * @constructor
 */
var MongoConnector = function(database) {
    var mongoClass = Java.type("nl.mawoo.migratejs.extend.dbconnector.MongoConnector");
    return new mongoClass(database);
};

