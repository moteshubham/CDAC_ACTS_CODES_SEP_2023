package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	// add a static method to ret DB connection
	public static Connection openConnection() throws 
	/*ClassNotFoundException*/ SQLException {
		// 1. optional step , load JDBC driver
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. mandatory step : establish connection with db
		// java.sql.DriverManager :class
		// API : public static Connection getConnection(String dbURL,String userName,
		// String pwd)throws SQLException
		String dbURL = "jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true";
		return DriverManager.getConnection(dbURL, "root", "root");

	}
}
