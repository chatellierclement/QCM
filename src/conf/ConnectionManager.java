package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class ConnectionManager {

	static String url = "jdbc:sqlserver://10.1.0.68:1433;databasename=QCM";
	static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String username = "sa";
	static String password = "Pa$$w0rd";
	static Connection con = null;

	private static Logger logger = Logger.getLogger(ConnectionManager.class);
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
				System.out.println("marche");
			} catch (SQLException ex) {
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
				logger.error("L'url ou l'username ou le password pour la connexion est mal renseigné ! dans le fichier ConnectionManager.java");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
			logger.error("Le driver n'a pas été trouvé, vous n'avez sans doute pas importer dans le build path le jar correspond...");
		}
		return con;
	}

}
