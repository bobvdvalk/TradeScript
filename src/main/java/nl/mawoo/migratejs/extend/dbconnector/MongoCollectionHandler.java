package nl.mawoo.migratejs.extend.dbconnector;

import com.mongodb.client.FindIterable;
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
    private DocumentConverter documentConverter;

    /**
     * Set a collection
     * @param collection Collection you want to use
     */
    public MongoCollectionHandler(MongoCollection<Document> collection) {
        this.collection = collection;
        documentConverter = new DocumentConverter();
    }

    /**
     * insert data into MongoDB
     * @param input string with JSON
     */
    public void insertOne(String input) {
        Document document = documentConverter.jsonConverter(input);
        collection.insertOne(document);
    }

    /**
     * Count a document
     * @param input document type
     * @return number of the count
     */
    public long count(String input) {
        Document document = documentConverter.jsonConverter(input);
        return collection.count(document);
    }

    /**
     * Update one document
     * @param input document that has to be updated
     * @param input2 updated document
     */
    public void updateOne(String input, String input2) {
        Document document = documentConverter.jsonConverter(input);
        Document document2 = documentConverter.jsonConverter(input2);

        collection.updateOne(document, document2);
    }

    /**
     * Update multiple document
     * @param input document that has to be updated
     * @param input2 updated document
     */
    public void updateMany(String input, String input2) {
        Document document = documentConverter.jsonConverter(input);
        Document document2 = documentConverter.jsonConverter(input2);

        collection.updateMany(document, document2);
    }

    // TODO: finish this function
    public FindIterable<Document> find(String input) {
        Document document = documentConverter.jsonConverter(input);
        return collection.find(document);
    }

    /**
     * Delete one record
     * @param input document in json type
     */
    public void deleteOne(String input) {
        Document document = documentConverter.jsonConverter(input);
        collection.deleteOne(document);
    }

    /**
     * Delete Multiple documents
     * @param input document in json format.
     */
    public void deleteMany(String input) {
        Document document = documentConverter.jsonConverter(input);
        collection.deleteMany(document);
    }

    /**
     * Find one document and delete
     * @param input document as string in json format
     */
    public void findOneAndDelete(String input) {
        Document document = documentConverter.jsonConverter(input);
        collection.findOneAndDelete(document);
    }
}
