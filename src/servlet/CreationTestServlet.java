package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CategorieBO;
import bo.TestBO;
import dao.CategorieDAO;
import dao.TestDAO;

/**
 * Servlet implementation class CreationTest
 */
@WebServlet("/creationTest")
public class CreationTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
		int categorieId = Integer.parseInt(request.getParameter("categorieId"));
		int nbQuestion = Integer.parseInt(request.getParameter("nbQuestion"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		
		TestBO unTest = new TestBO();
		CategorieBO uneCategorie = new CategorieBO();
		unTest.setLibelle(libelle);
		uneCategorie.setId(categorieId);
		unTest.setCategorie(uneCategorie);
		unTest.setNbQuestion(nbQuestion);
		unTest.setDuree(duree);
		
		try {
			TestDAO.creationTest(unTest);
			response.sendRedirect("logged");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void generate(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("creationTest.jsp");
		
		List<CategorieBO> lesCategories = null;
		lesCategories = CategorieDAO.getAll();
		
		req.setAttribute("lesCategories", lesCategories);
		
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
