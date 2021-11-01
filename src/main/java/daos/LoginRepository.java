package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.DbConnection;
import models.Login;

public class LoginRepository {
	private Connection connection;
    private static final String TABLE = "users";

    public LoginRepository() {
        this.connection = DbConnection.getConnection();
    }

    public boolean login(Login login) throws SQLException {
    	String sql = "select * from " + TABLE + " where upper(login) = upper(?) and upper(password) = upper(?)";
    	PreparedStatement sts = connection.prepareStatement(sql);
    	sts.setString(1, login.getUser());
    	sts.setString(2, login.getPassword());
    	ResultSet result = sts.executeQuery();
    	
    	if(result.next()) {
    		return true;
    	}
    	
    	return false;
    }
    
}