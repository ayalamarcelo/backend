package filmoteca.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             BufferedReader br = new BufferedReader(new FileReader("src/main/resources/db/schema.sql"))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            String sql = sb.toString();
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}