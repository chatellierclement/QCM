package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.CategorieBO;
import conf.ConnectionManager;

public class CategorieDAO {

	public static List<CategorieBO> getAll(){

		List<CategorieBO> listCategories = new ArrayList<CategorieBO>();
		try {

			Connection con = ConnectionManager.getConnection();
			String data = "SELECT * FROM CATEGORIE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(data);
			
			while(rs.next())
			{
				CategorieBO pCategorie = new CategorieBO();
				pCategorie.setId(rs.getInt(1));
				pCategorie.setLibelle(rs.getString(2));
				listCategories.add(pCategorie);
			}
			
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCategories;
	}
	
	public static void enregistrer(CategorieBO categorie) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String req = "INSERT INTO CATEGORIE VALUES (?) ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req);
		stmt.setString(1, categorie.getLibelle());
		stmt.executeUpdate();

		stmt.close();
		con.close();
	}
}
