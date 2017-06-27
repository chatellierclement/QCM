package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static String url = "jdbc:sqlserver://10.1.0.68:1433;databasename=eniProjet";
	static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String username = "sa";
	static String password = "Pa$$w0rd";
	static Connection con = null;

	public static Connection getConnection() {

		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
				System.out.println("marche");
			} catch (SQLException ex) {
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
		}
		return con;
	}

}
