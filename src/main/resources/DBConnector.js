/**
 * Create a connection to a database
 * @param connString ConnectionString to connect to a database type
 * @param username login name of the database
 * @param password login password of the database
 * @constructor init a database connection
 */
var DbConnector = function(connString, username, password) {
    var DBConnector = Java.type("nl.mawoo.migratejs.extend.dbconnector.DbConnector");
    this.connector = new DBConnector(connString, username, password);
};
/**
 * Run a query to the database.
 * @param sql database query.
 */
DbConnector.prototype.query = function(sql){
    return this.connector.query(sql);
};