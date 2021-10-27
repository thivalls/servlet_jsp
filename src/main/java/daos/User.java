package daos;

import java.sql.Connection;

import connections.DbConnection;

public class User {
	private Connection connection;
    private static final String TABLE = "users";

    public User() {
        this.connection = DbConnection.getConnection();
    }

    
}