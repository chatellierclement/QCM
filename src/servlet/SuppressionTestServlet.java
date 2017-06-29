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

import bo.QuestionBO;
import bo.TestBO;
import bo.Utilisateur;
import dao.QuestionDAO;
import dao.TestDAO;

/**
 * Servlet implementation class SuppressionTest
 */
@WebServlet("/suppressionTest")
public class SuppressionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}
	
	private void generate(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Utilisateur sessionUtilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");

		if (sessionUtilisateur == null) {
			try {
				resp.sendRedirect("login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				TestDAO.SupprimerTest(id);
				resp.sendRedirect("logged");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}