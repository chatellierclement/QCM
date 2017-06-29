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
import bo.TestBO;
import conf.ConnectionManager;

public class TestDAO {
	public static List<TestBO> selectAll() throws SQLException {
		List<TestBO> listTestBO = new ArrayList<TestBO>();
		Connection con = ConnectionManager.getConnection();
		Statement state = con.createStatement();
		String req = "SELECT * FROM test";
		ResultSet res = state.executeQuery(req);

		while (res.next()) {
			TestBO testBO = new TestBO();
			testBO.setId(res.getInt(1));
			testBO.setLibelle(res.getString(2));
			listTestBO.add(testBO);
		}

		res.close();
		state.close();
		con.close();
		
		return listTestBO;
	}
	
	public static void Editiontest(TestBO test) throws SQLException {
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
	
	public static TestBO selectTestById(int idTest) throws SQLException {
		TestBO unTest = new TestBO();
		CategorieBO uneCategorie = new CategorieBO();
		Connection con = ConnectionManager.getConnection();
		String req = "SELECT * FROM test WHERE idTest = ?";
		PreparedStatement st = con.prepareStatement(req);
		st.setInt(1, idTest);
		ResultSet res = st.executeQuery();
		
		while (res.next()) {
			unTest.setId(res.getInt(1));
			unTest.setLibelle(res.getString(2));
			uneCategorie.setId(res.getInt(3));
			unTest.setCategorie(uneCategorie);
			unTest.setNbQuestion(res.getInt(4));
			unTest.setDuree(res.getInt(5));
		}

		res.close();
		st.close();
		con.close();
		
		return unTest;
	}
	
	public static void SupprimerTest(int idTest) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String req = "DELETE FROM Test WHERE idTest = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(req);
			st.setInt(1, idTest);
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void creationTest(TestBO test) throws SQLException {
		
		Connection con = ConnectionManager.getConnection();
		String req = "INSERT INTO Test (libelle, idCategorie, nbQuestion, duree) VALUES (?, ?, ?, ?)";
		
		try {
		    PreparedStatement st = con.prepareStatement(req);
		    st.setString(1, test.getLibelle());
		    st.setInt(2, test.getCategorie().getId());
		    st.setInt(3, test.getNbQuestion());
		    st.setInt(4, test.getDuree());

		    st.executeUpdate();
		    st.close();
		  } 
		  catch (SQLException e)
		  {
		    throw e;
		  }
		
	}
	
}
