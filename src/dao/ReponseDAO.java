package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.CategorieBO;
import bo.QuestionBO;
import bo.ReponseBO;
import conf.ConnectionManager;

public class ReponseDAO {

	public static List<ReponseBO> selectAllByQuestion(int id)
			throws SQLException {
		ReponseBO pReponse = null;
		QuestionBO pQuestion = null;
		List<ReponseBO> pListeReponse = new ArrayList<ReponseBO>();

		Connection con = ConnectionManager.getConnection();
		String req = "select * from Reponse where idQuestion = ? ";
		PreparedStatement stmt;
		stmt = con.prepareStatement(req);
		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();

		while (res.next()) {
			pReponse = new ReponseBO();
			pQuestion = new QuestionBO();

			pQuestion.setId(id);

			pReponse.setId(res.getInt(1));
			pReponse.setLibelle(res.getString(2));
			pReponse.setEtat(res.getInt(3));
			pReponse.setIdQuestion(pQuestion);

			pListeReponse.add(pReponse);
		}

		res.close();
		stmt.close();
		con.close();

		return pListeReponse;
	}
}