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
import bo.TestBO;
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
	
	public static void updateReponse(int idReponse, int idUtilisateur)
			throws SQLException {

		Connection con = ConnectionManager.getConnection();
		String req = "UPDATE ReponseUti SET idReponse = ? WHERE idUtilisateur = ?";

		PreparedStatement stmt;
		stmt = con.prepareStatement(req);

		stmt.setInt(2, idUtilisateur);
		stmt.setInt(1, idReponse);
		
		stmt.executeUpdate();

		stmt.close();
		con.close();

	}
	// a modifier !
	public static void update(TestBO test) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String req = "UPDATE Test SET libelle = ?,"
				+ "idCategorie = ?, nbQuestion = ?, duree = ? WHERE idTest = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(req);
			st.setString(1, test.getLibelle());
			st.setInt(2, test.getCategorie().getId());
			st.setInt(3, test.getNbQuestion());
			st.setInt(4, test.getDuree());
			st.setInt(5, test.getId());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static List<Integer> verifReponse(int id)	throws SQLException {
		List<Integer> listeValue = new ArrayList<Integer>();
		Connection con = ConnectionManager.getConnection();
		String req = "select rep.idQuestion from ReponseUti r,"
				+ " Reponse rep where r.idReponse = rep.idReponse and r.idUtilisateur = ?";

		PreparedStatement stmt;
		stmt = con.prepareStatement(req);

		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();

		while (res.next()) {
			listeValue.add(res.getInt(1));
		}

		res.close();
		stmt.close();
		con.close();

		return listeValue;
	}
	
	
}