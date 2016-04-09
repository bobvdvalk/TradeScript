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

    public MongoConnector(String database) {
        client = new MongoClient(new ServerAddress());
        this.database = client.getDatabase(database);
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
