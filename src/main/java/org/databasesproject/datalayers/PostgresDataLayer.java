package org.databasesproject.datalayers;

import org.databasesproject.DatabaseConnectConfig;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresDataLayer extends DataLayer {
    private final DatabaseConnectConfig config;
    private Connection conn;

    public PostgresDataLayer(DatabaseConnectConfig config) {
        this.config = config;
    }

    @Override
    public void connectToDB() {
        String connectionURL = "jdbc:postgresql://" + this.config.getHost() + ":" + this.config.getPort() + "/" + this.config.getDbName();
        try {
            this.conn = DriverManager.getConnection(connectionURL, this.config.getUsn(), this.config.getPwd());
        } catch (SQLException ex) {
            Logger.getLogger(PostgresDataLayer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveInfo(String mainInfo) {
        this.connectToDB();
        try {
            String insertionQuery = "INSERT INTO main_info (data) VALUES (?)";
            PreparedStatement preparedStatement = this.conn.prepareStatement(insertionQuery);
            preparedStatement.setString(1, mainInfo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresDataLayer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void viewInfo() {
        try {
            String selectionQuery = "SELECT * FROM main_info";
            PreparedStatement preparedStatement = this.conn.prepareStatement(selectionQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                System.out.println("Main information: " + data);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresDataLayer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresDataLayer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
}
