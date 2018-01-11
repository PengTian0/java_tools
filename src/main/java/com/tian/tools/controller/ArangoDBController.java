package com.tian.tools.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
 
import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.model.AqlQueryOptions;
import com.arangodb.util.MapBuilder;
import com.arangodb.velocypack.VPackSlice;
import com.arangodb.velocypack.exception.VPackException;

public class ArangoDBController {


    private static final ArangoDB arangoDB = new ArangoDB.Builder().host("10.62.59.178", 8529).user("root").password("root").build();

    public static boolean createUser(String username, String password){
        try{
            arangoDB.createUser(username, password);
            System.out.println("User created: " + username);
            return true;
        } catch (ArangoDBException e){
            System.err.println("Failed to create user: " + username + "; " + e.getMessage());
            return false;
        }
    }

    public static boolean createDatabase(String dbName) {
        try{
            arangoDB.createDatabase(dbName);
            System.out.println("Database created: " + dbName);
            return true;
        } catch (ArangoDBException e){
            System.err.println("Failed to create database: " + dbName + "; " + e.getMessage());
            return false;
        }
    }

    public static boolean createCollection(String dbName, String collectionName) {
        try {
            CollectionEntity myArangoCollection = arangoDB.db(dbName).createCollection(collectionName);
            System.out.println("Collection created: " + myArangoCollection.getName());
            return true;
        } catch (ArangoDBException e) {
            System.err.println("Failed to create collection: " + collectionName + "; " + e.getMessage());
            return false;
        }
    }

    public static boolean createNode(String dbName, String collectionName, BaseDocument myObject){
        try {
            arangoDB.db(dbName).collection(collectionName).insertDocument(myObject);
            System.out.println("Node created");
            return true;
        } catch (ArangoDBException e) {
            System.err.println("Failed to create Node: " + e.getMessage());
            return false;
        }
    }
}
