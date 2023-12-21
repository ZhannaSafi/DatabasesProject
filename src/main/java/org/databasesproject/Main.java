package org.databasesproject;

import org.databasesproject.datalayers.DataLayer;
import org.databasesproject.datalayers.MongoDataLayer;
import org.databasesproject.datalayers.PostgresDataLayer;
import org.databasesproject.dataservices.DataService;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectConfig postgresConnectionConfig =
                new DatabaseConnectConfig(
                        5432, "localhost", "pgDatabase", "postgres", "hamer222"),
                mongoConnectionConfig = new DatabaseConnectConfig(
                        27017, "localhost", "mongoDatabase", "mohaboko31", "pD4xNVqEulAAbaXt");
        DataLayer postgresDataLayer = new PostgresDataLayer(postgresConnectionConfig),
                mongoDataLayer = new MongoDataLayer(mongoConnectionConfig);
        DataService dataService = new DataService(postgresDataLayer, mongoDataLayer);
        for (int i = 0; i < 6; i++) {
            dataService.saveData("Main info" + i, "Meta info" + i);
        }
        dataService.viewData();
    }
}