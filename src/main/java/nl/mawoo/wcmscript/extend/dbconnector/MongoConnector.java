package nl.mawoo.wcmscript.extend.dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * This class is responsible to manage the connection with MongoDB
 */
public class MongoConnector {
    private MongoDatabase database;
    private MongoClient client;

    /**
     * Login with no credentials
     * @param database collection that you want to use.
     */
    public MongoConnector(String database) {
        client = new MongoClient(new ServerAddress());
        this.database = client.getDatabase(database);
    }

    public MongoConnector(MongoDatabase database, String username, String password) {
        this.database = database;
    }

    /**
     * Login using all credentials
     * @param database
     * @param username
     * @param password
     * @param host
     * @param password
     */
    public MongoConnector(MongoDatabase database, String username, String password, String host, String password) {
        this.database = database;
    }

    /**
     * Get a collection
     * @param collection string of the collection you want to use
     * @return MongoCollectionHandler so you can input data
     */
    public MongoCollectionHandler getCollection(String collection) {
        return new MongoCollectionHandler(database.getCollection(collection));
    }

}
