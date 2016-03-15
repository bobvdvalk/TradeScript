package nl.mawoo.migratejs.extend.dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * This class is responsible for the connection to MongoDB
 *
 * @author Bob van der Valk
 */
public class MongoDBConnector {

    private MongoDatabase db;

    /**
     * Start a MongoDB client
     * @param database collection you want to connect.
     */
    public MongoDBConnector(String database) {
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDatabase(database);
    }

    /**
     * Insert data into collection
     * @param table collection name
     * @param input json/document input
     * TODO: Create method to input json and convert to document
     */
    public void insert(String table, Document input) {
        db.getCollection(table).insertOne(input);
    }

}
