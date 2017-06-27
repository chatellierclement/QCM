/*package dao;

import bo.CandidatBO;

public class CandidatDAO {

	public CandidatBO selectAll() {
		//Connection con = models.Connect.Connection();
		//Statement state = con.createStatement();
		ResultSet res = state
				.executeQuery("SELECT * FROM visiteur WHERE VIS_MATRICULE='"
						+ log + "' AND VIS_NOM ='" + mdp + "'");

		if (res.next()) {
			String login = res.getString("VIS_MATRICULE");
			String pass = res.getString("VIS_NOM");
			CandidatBO candidatBO = new CandidatBO(login, pass);
		}

		res.close();
		state.close();
		con.close();
	}
}*/
