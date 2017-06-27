package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conf.ConnectionManager;
import bo.CandidatBO;

public class CandidatDAO {

	public CandidatBO selectOneByNomPrenom() throws SQLException {
		CandidatBO candidatBO = null;
		Connection con = ConnectionManager.getConnection();
		Statement state = con.createStatement();
		String req = "SELECT * FROM candidat WHERE nom = ? AND prenom = ? ";
		ResultSet res = state.executeQuery(req);

		if (res.next()) {
			candidatBO = new CandidatBO();
			candidatBO.setId(1);
			candidatBO.setNom(res.getString(2));
			candidatBO.setPrenom(res.getString(3));
		}

		res.close();
		state.close();
		con.close();
		
		return candidatBO;
	}
}
