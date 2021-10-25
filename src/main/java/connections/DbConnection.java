package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static String dbhost = "jdbc:postgresql://localhost:5432/servlet";
    private static String dbuser = "postgres";
    private static String dbpass = "valls";
    private static Connection connection = null;

    static {
        connect();
    }

    public DbConnection() {
        connect();
    }

    private static void connect() {
        try {
            if(connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(dbhost, dbuser, dbpass);
                connection.setAutoCommit(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}