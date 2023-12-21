package org.databasesproject.dataservices;

import org.databasesproject.datalayers.DataLayer;

public class DataService {
    private final DataLayer postgresDataLayer, mongoDataLayer;

    public DataService(DataLayer postgresDataLayer, DataLayer mongoDataLayer) {
        this.postgresDataLayer = postgresDataLayer;
        this.mongoDataLayer = mongoDataLayer;
    }

    public void saveData(String mainInfo, String metaInfo) {
        this.postgresDataLayer.saveInfo(mainInfo);
        this.mongoDataLayer.saveInfo(metaInfo);
    }

    public void viewData() {
        this.postgresDataLayer.viewInfo();
        this.mongoDataLayer.viewInfo();
    }

    public void close() {
        this.postgresDataLayer.close();
        this.mongoDataLayer.close();
    }
}
