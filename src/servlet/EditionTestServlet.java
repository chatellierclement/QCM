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
 * Servlet implementation class EditionTestServlet
 */
@WebServlet("/editionTest")
public class EditionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
		int categorieId = Integer.parseInt(request.getParameter("categorieId"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		TestBO unTest = new TestBO();
		CategorieBO uneCategorie = new CategorieBO();
		unTest.setId(id);
		unTest.setLibelle(libelle);
		uneCategorie.setId(categorieId);
		unTest.setCategorie(uneCategorie);
		try {
			TestDAO.Editiontest(unTest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		generate(request, response);
	}
	
	private void generate(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("editionTest.jsp");
		
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			TestBO unTest = TestDAO.selectTestById(id);
			req.setAttribute("unTest", unTest);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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