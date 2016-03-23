package nl.mawoo.migratejs.extend.dbconnector;

import com.mongodb.client.MongoCollection;
import nl.mawoo.migratejs.converter.DocumentConverter;
import org.bson.Document;

/**
 * This class is responsible to handle the collection inputs
 *
 * @author Bob van der Valk
 */
public class MongoCollectionHandler {
    private MongoCollection<Document> collection;

    /**
     * Set a collection
     * @param collection Collection you want to use
     */
    public MongoCollectionHandler(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    /**
     * insert data into MongoDB
     * @param input string with JSON
     */
    public void insertOne(String input) {
        DocumentConverter documentConverter = new DocumentConverter();
        Document data = documentConverter.jsonConverter(input);
        collection.insertOne(data);
    }
}
