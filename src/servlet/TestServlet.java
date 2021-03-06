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
import dao.ReponseUtilDAO;
import dao.TestDAO;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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

			RequestDispatcher dispatcher = req.getRequestDispatcher("test.jsp");

			int id = Integer.parseInt(req.getParameter("idTest"));
			
			Utilisateur u = (Utilisateur) req.getSession().getAttribute("utilisateur");
			List<QuestionBO> unTest = null;
			try {
				unTest = QuestionDAO.selectAllByCategorie(id);
				List<Integer> verifReponse = ReponseUtilDAO.verifReponse(u.getId());	
				req.setAttribute("idTest", String.valueOf(id));
				req.setAttribute("unTest", unTest);
				req.setAttribute("verifReponse", verifReponse);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
