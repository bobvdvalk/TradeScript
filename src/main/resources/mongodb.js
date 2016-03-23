/**
 * Connect to a MongoDB Library
 * @constructor
 */
/**
 * Start a MongoDB client with custom host, port, username, password
 * @param host Address of MongoDB
 * @param port Port of MongoDB
 * @param database Database you want to use
 * @param username credentials
 * @param password credentials
 */
//public MongoDBConnector(String host, int port, String database, String username, char[] password) {
//    MongoCredential credential = MongoCredential.createCredential(username, database, password);
//    mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
//
//    db = mongoClient.getDatabase(database);
//
//}
var MongoDBConnect = function(database) {
    var mongoClass = Java.type("nl.mawoo.migratejs.extend.dbconnector.MongoDBConnector");

    this.connector = new mongoClass(database);
    return this.connector.getDb();
};

