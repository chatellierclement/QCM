package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.QuestionBO;
import bo.ReponseBO;
import bo.ReponseUtiBO;
import conf.ConnectionManager;

public class ReponseUtilDAO {

	public static void enregistrerReponse(int idReponse, int idUtilisateur)
			throws SQLException {

		Connection con = ConnectionManager.getConnection();
		String req = "INSERT INTO ReponseUti (idUtilisateur, idReponse) VALUES (?, ?)";

		PreparedStatement stmt;
		stmt = con.prepareStatement(req);

		stmt.setInt(1, idUtilisateur);
		stmt.setInt(2, idReponse);
		
		stmt.executeUpdate();

		stmt.close();
		con.close();

	}
}