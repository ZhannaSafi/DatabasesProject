module databasesproject {
    exports org.databasesproject.datalayers;
    exports org.databasesproject.dataservices;
    exports org.databasesproject;

    requires java.logging;
    requires java.sql;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
}