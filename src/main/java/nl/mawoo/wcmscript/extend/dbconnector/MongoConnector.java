package nl.mawoo.wcmscript.extend.dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * This class is responsible to manage the connection with MongoDB
 */
public class MongoConnector {
    private String currentDatabase;
    private String host = "127.0.0.1";
    private int port = 27017;
    private String username = null;
    private String password = null;

    private MongoDatabase database;

    /**
     * Login with no credentials
     * @param database collection that you want to use.
     */
    public MongoConnector(String database) {
        this.currentDatabase = database;
    }

    /**
     * Make the connection to MongoDB
     */
    public void connect() {
        MongoClient client = new MongoClient(new ServerAddress());
        this.database = client.getDatabase(currentDatabase);
    }

    /**
     * Get a collection
     * @param collection string of the collection you want to use
     * @return MongoCollectionHandler so you can input data
     */
    public MongoCollectionHandler getCollection(String collection) {
        return new MongoCollectionHandler(database.getCollection(collection));
    }

    /**
     * Replace default host
     * Default is: "localhost"
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Replace default port
     * Default port is "27017"
     * @param port MongoDB connection port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Replace default username
     * Default username is "null"
     * @param username String of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Replace default password
     * @param password String of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
