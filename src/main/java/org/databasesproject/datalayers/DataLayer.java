package org.databasesproject.datalayers;

public abstract class DataLayer {
    public abstract void connectToDB();

    public abstract void saveInfo(String info);

    public abstract void viewInfo();

    public abstract void close();
}
