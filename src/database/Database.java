package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Asus on 28.05.2017.
 */
public class Database {
    Connection connection;

    public void prepareConnection(String url){
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Database connection error");
        }
    }

    public void executeCreate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Execute query error");
        }
    }
}
