package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.CandidatDAO;
import bo.CandidatBO;

public class CandidatTest {
	
	@Test
	public void testEnregistrer() throws SQLException {
		
		CandidatBO candidatBO = new CandidatBO();
		candidatBO.setNom("Nom");
		candidatBO.setPrenom("prenom");
		
		CandidatDAO.enregistrer(candidatBO);		
		
		CandidatBO candidatBO2 = CandidatDAO.selectOneByNomPrenom(candidatBO.getNom(), candidatBO.getPrenom());
		
		assertEquals(candidatBO.getNom(), candidatBO2.getNom());
		assertEquals(candidatBO.getPrenom(), candidatBO2.getPrenom());
	}
}
