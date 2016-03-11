DBConnector = {
    DBConnectorClass: "",
    connection: "",

    /**
     * Set up a connection to the database
     * @param connection connection string to connect.
     * @param user user of the database
     * @param pass password of the database
     */
    __construct: function(connection, user, pass) {
        var klasse = Java.Type("nl.mawoo.migratejs.extend.dbconnector.DbConnector");

        this.connection = connection;

        this.DBConnectorClass = new DBConnectorClass(connection, user, pass);
     },
    /**
     * Run a mysql query
     * @param sql your sql query
     */
    query: function(sql) {
        this.DBConnectorClass.query(sql);
    }
};