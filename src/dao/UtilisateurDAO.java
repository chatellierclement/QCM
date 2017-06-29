package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.CategorieBO;
import bo.Utilisateur;
import conf.ConnectionManager;

public class UtilisateurDAO {
	
	public static List<Utilisateur> getAll(){

		List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
		try {

			Connection con = ConnectionManager.getConnection();
			String data = "SELECT * FROM UTILISATEUR where TYPE = 'Candidat'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(data);
			
			while(rs.next())
			{
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt(1));
				utilisateur.setNom(rs.getString(2));
				utilisateur.setPrenom((rs.getString(3)));
				utilisateur.setType(rs.getString(4));
				lesUtilisateurs.add(utilisateur);
			}
			
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lesUtilisateurs;
	}
	
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
