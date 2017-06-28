package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conf.ConnectionManager;
import bo.CandidatBO;

public class CandidatDAO {

	public static CandidatBO selectOneByNomPrenom(String nom, String prenom) throws SQLException {
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
			candidatBO.setId(res.getInt(1));
			candidatBO.setNom(res.getString(2));
			candidatBO.setPrenom(res.getString(3));
		}

		res.close();
		stmt.close();
		con.close();
		
		return candidatBO;
	}

	public static List<CandidatBO> getAll(){

		List<CandidatBO> listPersonnes = new ArrayList<CandidatBO>();
		try {

			Connection con = ConnectionManager.getConnection();
			String data = "select * from Candidat";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(data);
			while (rs.next()){
				CandidatBO pCandidat = new CandidatBO();
				pCandidat.setId(rs.getInt(1));
				pCandidat.setNom(rs.getString(2));
				pCandidat.setPrenom(rs.getString(3));
				listPersonnes.add(pCandidat);
			}
			
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return listPersonnes;
	}
	
	public static void enregistrer(CandidatBO candidat) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String req = "INSERT INTO CANDIDAT VALUES (?,?) ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req);
		stmt.setString(1, candidat.getNom());
		stmt.setString(2, candidat.getPrenom());
		stmt.executeUpdate();

		stmt.close();
		con.close();
	}
}
