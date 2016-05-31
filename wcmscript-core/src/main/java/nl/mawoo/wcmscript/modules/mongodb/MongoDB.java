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

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import nl.mawoo.wcmscript.AbstractScriptModule;

import java.util.Arrays;

/**
 * This class is responsible to connect to a MongoDB connection
 *
 * @author Bob van der Valk
 */
public class MongoDB extends AbstractScriptModule {
    private String currentDatabase;
    private String host = "127.0.0.1";
    private int port = 27017;

    private MongoClient client;
    private MongoDatabase database;

    public MongoDB() {

    }

    /**
     * Set a database that has to be used
     * @param currentDatabase database you want to use
     */
    public MongoDB setDatabase(String currentDatabase) {
        this.currentDatabase = currentDatabase;
        return this;
    }

    /**
     * Change default host
     * default: 127.0.0.1
     * @param host
     */
    public MongoDB setHost(String host) {
        this.host = host;
        return this;
    }

    public MongoDB setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Connect to MongoDB without authentication
     * This methods opens the connection to the MongoDB server and sets the database that is set.
     * @return this
     */
    public MongoDB connect() {
        client = new MongoClient(new ServerAddress(host, port));
        database = client.getDatabase(currentDatabase);
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
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(username, this.currentDatabase, password.toCharArray());
        client = new MongoClient(new ServerAddress(host, port), Arrays.asList(mongoCredential));
        database = client.getDatabase(currentDatabase);
        return this;
    }

    /**
     * Get a MongoDB collection and return a MongoCollectionHanlder
     * @param collection collection you want to use
     * @return MongoCollectionHandler to CRUDd
     */
    public MongoCollectionHandler getCollection(String collection) {
        return new MongoCollectionHandler(database.getCollection(collection));
    }

    /**
     * Close the MongoDB connection
     */
    public void close() {
        client.close();
    }
}

