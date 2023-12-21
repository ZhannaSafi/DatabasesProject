package org.databasesproject;

public class DatabaseConnectConfig {
    private int port;
    private String host, dbName, usn, pwd;

    public DatabaseConnectConfig(final int port, final String host, final String dbName, final String usn, final String pwd) {
        this.setPort(port);
        this.setHost(host);
        this.setDbName(dbName);
        this.setUsn(usn);
        this.setPwd(pwd);
    }

    public final int getPort() {
        return this.port;
    }

    public final void setPort(int port) {
        this.port = port;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String host) {
        this.host = host;
    }

    public final String getDbName() {
        return this.dbName;
    }

    public final void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public final String getUsn() {
        return this.usn;
    }

    public final void setUsn(String usn) {
        this.usn = usn;
    }

    public final String getPwd() {
        return this.pwd;
    }

    public final void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
