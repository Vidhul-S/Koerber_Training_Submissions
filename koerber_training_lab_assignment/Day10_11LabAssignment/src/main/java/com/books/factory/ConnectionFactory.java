package com.books.factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//factory of connection
public class ConnectionFactory {

    public static Connection connection = null;

    public static Connection getConnection() {
        //'is' need to get the value from properties file
        InputStream is = ConnectionFactory
                .class.getClassLoader()
                .getResourceAsStream("dbconn.properties");

        Properties properties = new Properties(); //k v string to read the properties file
        try {
            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Close the terminal with the sql table open and retry", e);
        }

        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverName = properties.getProperty("jdbc.drivername");

        try {
            Class.forName(driverName);
            //System.out.println("driver is loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager
                    .getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
