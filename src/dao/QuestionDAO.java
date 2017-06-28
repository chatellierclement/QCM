package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.CategorieBO;
import bo.QuestionBO;
import bo.TestBO;
import conf.ConnectionManager;

public class QuestionDAO {

	public static List<QuestionBO> selectAllByCategorie(int id) throws SQLException {
			QuestionBO questionBO = null;
			List<QuestionBO> listQuestionBO = new ArrayList<QuestionBO>();
			
			Connection con = ConnectionManager.getConnection();
			String req = "SELECT t.idTest, t.libelle, c.idCategorie, c.libelle, q.idQuestion, q.libelle FROM TEST t " 
					+ "INNER JOIN CATEGORIE c ON t.idCategorie = c.idCategorie "
					+ "INNER JOIN QUESTION q ON c.idCategorie = q.idCategorie "
					+ "WHERE t.idTest = ?";
			PreparedStatement stmt;
			stmt = con.prepareStatement(req);
			stmt.setInt(1, id);
			ResultSet res = stmt.executeQuery();
			
			while (res.next()) {
				questionBO = new QuestionBO();
				questionBO.setId(res.getInt(1));
				questionBO.setLibelle(res.getString(2));
				listQuestionBO.add(questionBO);
			}

			res.close();
			stmt.close();
			con.close();
			
			return listQuestionBO;
	}
	
}
