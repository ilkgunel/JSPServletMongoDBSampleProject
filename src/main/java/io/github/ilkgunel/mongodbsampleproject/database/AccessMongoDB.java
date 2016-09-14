/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ilkgunel.mongodbsampleproject.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author ilkaygunel
 */
public class AccessMongoDB {
    public MongoDatabase getMongoDatabase() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("MongoDB");
        //mongoClient.close();
        return mongoDatabase;
    }
}
