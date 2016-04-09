/**
 * Create a connection to a database
 * @param connString ConnectionString to connect to a database type
 * @param username login name of the database
 * @param password login password of the database
 * @constructor init a database connection
 */
var DbConnector = function(connString, username, password) {
    try {
        var DBConnector = Java.type("nl.mawoo.wcmscript.extend.dbconnector.DbConnector");
        this.connector = new DBConnector(connString, username, password);
    } catch(e) {
        print("Could not connect to the database \n Check your connection settings.");
    }
};

/**
 * Run a query to the database.
 * @param sql database query.
 */
DbConnector.prototype.query = function(sql){
    try {
        return this.connector.query(sql);
    } catch(e) {
        print("A SQL error occurred: "+ e);
    }
};