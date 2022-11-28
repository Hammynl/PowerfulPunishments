package io.github.hammynl.powerfulpunishments.utils;

import io.github.hammynl.powerfulpunishments.PowerfulPunishments;
import io.github.hammynl.powerfulpunishments.enums.Query;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseUtil {

    private Connection connection;
    private static DatabaseUtil instance;

    private DatabaseUtil() {}

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseUtil getInstance() {
        if(instance == null) {
            instance = new DatabaseUtil();
        }
        return instance;
    }



    public void setup(PowerfulPunishments plugin) {
        File file = new File(plugin.getDataFolder(), "data.db");

        try {
            // Create file if it does not exist
            if (!file.exists()) file.createNewFile();

            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());

            Statement statement = connection.createStatement();
            statement.executeQuery(Query.CREATE_PUNISHMENT_TABLE.toString());


        } catch (SQLException | IOException | ClassNotFoundException exception) {
            System.out.println("An error occured while trying to initiate the database connection");
            exception.printStackTrace();
        }
    }
}
