package filmoteca.database;

import java.io.BufferedReader;
import java.io.FileReader;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (var con = DatabaseConnection.getInitialConnection();
             var stmt = con.createStatement()) {
            var sqlFile = "src/main/resources/db/schema.sql";
            var sql = readSqlFile(sqlFile);

            var sqlStatements = sql.split(";");
            for (var sqlStatement : sqlStatements) {
                if (!sqlStatement.trim().isEmpty()) {
                    stmt.execute(sqlStatement.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readSqlFile(String filePath) {
        var content = new StringBuilder();
        try (var br = new BufferedReader(new FileReader(filePath))) {
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