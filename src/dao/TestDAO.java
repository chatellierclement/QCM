package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public static TestBO selectById(int id) throws SQLException {
		TestBO testBo = null;
		List<QuestionBO> questionBo = new ArrayList<QuestionBO>();
		
		Connection con = ConnectionManager.getConnection();
		String req = "SELECT * FROM TEST WHERE idTest = ?"; 
		PreparedStatement stmt;
		stmt = con.prepareStatement(req);
		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();
		
		if (res.next()) {
			testBo = new TestBO();
			testBo.setId(res.getInt(1));
			testBo.setLibelle(res.getString(2));
		}

		res.close();
		stmt.close();
		con.close();
		
		return testBo;
	}
}
