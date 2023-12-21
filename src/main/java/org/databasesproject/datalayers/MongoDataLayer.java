package org.databasesproject.datalayers;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.databasesproject.DatabaseConnectConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDataLayer extends DataLayer {
    private final DatabaseConnectConfig config;
    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;

    public MongoDataLayer(DatabaseConnectConfig config) {
        this.config = config;
    }

    @Override
    public void connectToDB() {
        String connectionURL = "mongodb://" + this.config.getHost() + ":" + this.config.getPort() + "/";
        ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionURL)).serverApi(serverApi).build();
        try {
            this.mongoClient = MongoClients.create(settings);
            this.mongoDatabase = this.mongoClient.getDatabase(this.config.getDbName());
        } catch (MongoException ex) {
            Logger.getLogger(MongoDataLayer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveInfo(String metaInfo) {
        this.connectToDB();
        Document document = new Document("data", metaInfo);
        this.mongoDatabase.getCollection("meta_info").insertOne(document);
    }

    @Override
    public void viewInfo() {
        FindIterable<Document> documents = this.mongoDatabase.getCollection("meta_info").find();
        for (Document document : documents) {
            String data = document.getString("data");
            System.out.println("Meta information: " + data);
        }
    }

    @Override
    public void close() {
        this.mongoClient.close();
    }
}
