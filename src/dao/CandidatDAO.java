package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conf.ConnectionManager;
import bo.CandidatBO;

public class CandidatDAO {

	public CandidatBO selectOneByNomPrenom(String nom, String prenom) throws SQLException {
		CandidatBO candidatBO = null;
		Connection con = ConnectionManager.getConnection();
		String req = "SELECT * FROM candidat WHERE nom = ? AND prenom = ? ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req);
		stmt.setString(1, nom);
		stmt.setString(2, prenom);
		ResultSet res = stmt.executeQuery();

		if (res.next()) {
			candidatBO = new CandidatBO();
			candidatBO.setId(1);
			candidatBO.setNom(res.getString(2));
			candidatBO.setPrenom(res.getString(3));
		}

		res.close();
		stmt.close();
		con.close();
		
		return candidatBO;
	}
}
