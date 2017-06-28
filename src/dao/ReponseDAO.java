package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bo.ReponseBO;
import conf.ConnectionManager;

public class ReponseDAO {

	public static void enregistrer(ReponseBO reponse) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String req = "INSERT INTO REP0NSE VALUES (?, ?, ?) ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req);
		stmt.setString(1, reponse.getLibelle());
		stmt.setInt(2, reponse.getEtat());
		stmt.setInt(3, reponse.getQuestion().getId());
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
	}
}
