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
		ResultSet res = state.executeQuery("SELECT * FROM visiteur WHERE VIS_MATRICULE='"
						+ "' AND VIS_NOM ='" + "'");

		if (res.next()) {
			String login = res.getString("");
			String pass = res.getString("");
			candidatBO = new CandidatBO();
			candidatBO.setId(1);
			candidatBO.setNom("");
			candidatBO.setPrenom("");
		}

		res.close();
		state.close();
		con.close();
		
		return candidatBO;
	}
}
