/**
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.mawoo.wcmscript.modules.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import nl.mawoo.wcmscript.logger.ScriptLogger;
import org.bson.Document;

/**
 * This class is responsible to handle the collection inputs.
 *
 * @author Bob van der Valk
 */
public class MongoCollectionHandler {
    private MongoCollection<Document> collection;
    private ScriptLogger scriptLogger;

    /**
     * This is called by the MongoDB class
     * @param collection collection that is used by the user
     * @param scriptLogger
     */
    public MongoCollectionHandler(MongoCollection<Document> collection, ScriptLogger scriptLogger) {
        this.collection = collection;
        this.scriptLogger = scriptLogger;
    }

    /**
     * Insert a json object into the database
     * @param json object  input from the user
     */
    public void insert(String json) {
        Document document = Document.parse(json);
        collection.insertOne(document);
    }
    
    /**
     * Insert a json object into the database
     * @param json object  input from the user
     */
    public void insertOne(String json) {
        Document document = Document.parse(json);
        collection.insertOne(document);
    }

    /**
     * Count everything in a collection
     * @return number of input
     */
    public long count() {
        return collection.count();
    }

    /**
     * Count everything you want with the query
     * @param json query you want to use to find data
     * @return
     */
    public long count(String json) {
        Document document = Document.parse(json);
        return collection.count(document);
    }

    /**
     * Find everything in the collection
     * @return json String of the collection
     */
    public MongoCursor<Document> find() {
        return collection.find().iterator();
    }

    /**
     * Find what you want using input
     * @param json json string of what you want to get
     * @return String with find output
     */
    public MongoCursor<Document> find(String json) {
        Document input = Document.parse(json);
        return collection.find(input).iterator();
    }

    /**
     * Update something in MongoDB
     * @param json input that has to be changed
     * @param json2 new input
     */
    public UpdateResult updateOne(String json, String json2) {
        Document input = Document.parse(json);
        Document input2 = Document.parse(json2);
        return collection.replaceOne(input, input2);
    }

    /**
     * Update many records in a collection (NOT SUPPORTED)
     * TODO: add update many
     * @param json input that has to be changed
     * @param json2 new input
     */
    public void updateMany(String json, String json2) {
        scriptLogger.error("\"updateMany()\" is not supported yet.");
    }

    /**
     * Delete 1 record from the collection
     * @param json input you want to delete
     */
    public void deleteOne(String json) {
        Document input = Document.parse(json);
        collection.deleteOne(input);
    }

    /**
     * Delete multiple records from a collection
     * @param json information in records you want to delete
     */
    public void deleteMany(String json) {
        Document input = Document.parse(json);
        collection.deleteMany(input);
    }
}
