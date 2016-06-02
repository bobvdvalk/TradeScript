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

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 * This class is responsible to handle the collection inputs.
 *
 * @author Bob van der Valk
 */
public class MongoCollectionHandler {
    private MongoCollection<Document> collection;

    /**
     * This is called by the MongoDB class
     * @param collection collection that is used by the user
     */
    public MongoCollectionHandler(MongoCollection<Document> collection) {
        this.collection = collection;
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
    public String find() {
        MongoCursor<Document> output = collection.find().iterator();

        BasicDBList list = new BasicDBList();
        while(output.hasNext()) {
            Document doc = output.next();
            list.add(doc);
        }

        return new Gson().toJson(list);
    }

    /**
     * Find what you want using input
     * @param input json string of what you want to get
     * @return String with find output
     */
    public String find(String json) {
       Document input = Document.parse(json);
       MongoCursor<Document> output = collection.find(input).iterator();

        BasicDBList list = new BasicDBList();
        while(output.hasNext()) {
            Document doc = output.next();
            list.add(doc);
        }

        return new Gson().toJson(list);
    }
}
