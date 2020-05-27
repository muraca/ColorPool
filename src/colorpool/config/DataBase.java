package colorpool.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private static DataBase instance;
	private Connection conn = null;
    private Statement stmt = null;
	public static DataBase getInstance() {
		if(instance == null)
			instance = new DataBase();
		return instance;
	}
	
	
	
	public DataBase() {
		try {
			Class.forName(Settings.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			Settings.throwError(7);
		}
        try {
			conn = DriverManager.getConnection(Settings.DB_URL, Settings.DB_USER, Settings.DB_PASS);
		} catch (SQLException e) {
			Settings.throwError(8);
		}
            
        
	}
	
	public void addRecord(String name, int points) {
        try {
			stmt = conn.createStatement();
			String query = "INSERT INTO RECORD VALUES " + name + " " + points + ";";
	        stmt.executeUpdate(query);
		} catch (SQLException e) {
			Settings.throwError(8);
		}
	}
}
