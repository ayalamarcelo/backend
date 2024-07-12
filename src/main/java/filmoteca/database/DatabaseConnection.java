package filmoteca.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "filmoteca";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
    }

    public static Connection getInitialConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
