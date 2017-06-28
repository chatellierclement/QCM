package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Utilisateur;
import conf.ConnectionManager;

public class UtilisateurDAO {
	
	public static Utilisateur selectOneByNomPrenom(String nom, String prenom) throws SQLException {
		Utilisateur utilisateur = null;
		Connection con = ConnectionManager.getConnection();
		String req = "SELECT * FROM utilisateur WHERE nom = ? AND prenom = ? ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req);
		stmt.setString(1, nom);
		stmt.setString(2, prenom);
		ResultSet res = stmt.executeQuery();

		if (res.next()) {
			utilisateur = new Utilisateur();
			utilisateur.setId(res.getInt(1));
			utilisateur.setNom(res.getString(2));
			utilisateur.setPrenom(res.getString(3));
			utilisateur.setType(res.getString(4));
		}

		res.close();
		stmt.close();
		con.close();
		
		return utilisateur;
	}
}
