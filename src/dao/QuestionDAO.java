package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.CategorieBO;
import bo.QuestionBO;
import conf.ConnectionManager;

public class QuestionDAO {
	
	public static List<QuestionBO> getAll(){

		List<QuestionBO> listeQuestions = new ArrayList<QuestionBO>();
		try {

			Connection con = ConnectionManager.getConnection();
			String data = "SELECT * FROM QUESTION";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(data);
			
			while(rs.next())
			{
				QuestionBO pQuestion = new QuestionBO();
				pQuestion.setId(rs.getInt(1));
				pQuestion.setLibelle(rs.getString(2));
				
				CategorieBO pCategorie = new CategorieBO() ;
				pCategorie.setId(rs.getInt(3));
				
				pQuestion.setCategorie(pCategorie) ;
				
				listeQuestions.add(pQuestion);
			}
			
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeQuestions;
	}

	public static List<QuestionBO> selectAllByCategorie(int id) throws SQLException {
		QuestionBO questionBO = null;
		CategorieBO categorieBO = null;
		List<QuestionBO> listQuestionBO = new ArrayList<QuestionBO>();
		
		Connection con = ConnectionManager.getConnection();
		String req = "SELECT c.idCategorie, c.libelle, q.idQuestion, q.libelle FROM TEST t " 
				+ "INNER JOIN CATEGORIE c ON t.idCategorie = c.idCategorie "
				+ "INNER JOIN QUESTION q ON c.idCategorie = q.idCategorie "
				+ "WHERE t.idTest = ?";
		PreparedStatement stmt;
		stmt = con.prepareStatement(req);
		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();
		
		while (res.next()) {
			questionBO = new QuestionBO();
			categorieBO = new CategorieBO();
			categorieBO.setId(res.getInt(1));
			categorieBO.setLibelle(res.getString(2));
			questionBO.setId(res.getInt(3));
			questionBO.setLibelle(res.getString(4));
			questionBO.setCategorie(categorieBO);
			listQuestionBO.add(questionBO);
		}

		res.close();
		stmt.close();
		con.close();
		
		return listQuestionBO;
	}
	
	public static int enregistrer(QuestionBO question) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String req = "INSERT INTO QUESTION VALUES (?, ?) ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, question.getLibelle());
		stmt.setInt(2, question.getCategorie().getId());
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		int dernierId = 0;
        if(rs.next())
        {
            dernierId = rs.getInt(1);
        }
		
		stmt.close();
		con.close();
		
		return dernierId;
	}
	
	public static void supprimer(int idQuestion) throws SQLException {
		//On supprime d'abord les réponses
		ReponseDAO.supprimerByIdQuestion(idQuestion) ;
		
		Connection con = ConnectionManager.getConnection();
		String req = "DELETE FROM QUESTION WHERE idQuestion = ? ";
		PreparedStatement stmt;
		
		stmt = con.prepareStatement(req);
		stmt.setInt(1, idQuestion);
		stmt.executeUpdate();

		stmt.close();
		con.close();
	}
}
