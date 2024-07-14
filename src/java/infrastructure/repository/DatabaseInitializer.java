package java.infrastructure.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection con = DatabaseConnection.getInitialConnection();
             Statement stmt = con.createStatement()) {
            String sqlFile = "src/main/resources/db/schema.sql";
            String sql = readSqlFile(sqlFile);

            String[] sqlStatements = sql.split(";");
            for (String sqlStatement : sqlStatements) {
                if (!sqlStatement.trim().isEmpty()) {
                    stmt.execute(sqlStatement.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readSqlFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
