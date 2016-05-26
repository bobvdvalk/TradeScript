package nl.mawoo.wcmscript.modules.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import nl.mawoo.wcmscript.AbstractScriptModule;

import java.util.Arrays;

/**
 * This class is responsible to connect to a MongoDB connection
 *
 * @author Bob van der Valk
 */
public class MongoDB extends AbstractScriptModule {
    private String currentDatabase = null;
    private String host = "127.0.0.1";
    private int port = 27017;
    private String username = null;
    private String password = null;

    public MongoDB() {

    }

    /**
     * Connect to MongoDB without authentication
     * This methods opens the connection to the MongoDB server and sets the database that is set.
     * @return this
     */
    public MongoDB connect() {
        MongoClient client = new MongoClient(new ServerAddress(host, port));
        client.getDatabase(currentDatabase);
        return this;
    }

    /**
     * Connect to MongoDB with authentication
     * This methods opens the connection to the MongoDB server and sets the database that is set.
     * @param username the username of the MongoDB server
     * @param password the password of the MongoDB server
     * @return this
     */
    public MongoDB connectAuthenticated(String username, String password) {
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(this.username, this.currentDatabase, this.password.toCharArray());
        MongoClient client = new MongoClient(new ServerAddress(host, port), Arrays.asList(mongoCredential));
        client.getDatabase(currentDatabase);
        return this;
    }
}

