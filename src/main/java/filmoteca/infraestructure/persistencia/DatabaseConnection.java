package filmoteca.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
        private static final String URL = "jdbc:mysql:/localhost:3300/";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        public static Connection getConnection() {
            try {
                System.out.println("Conexión establecida exitosamente.");
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Error al establecer la conexión con la Base de Datos.");
            }
            return null;
        }

    }
}
