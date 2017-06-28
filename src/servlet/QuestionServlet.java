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

import dao.QuestionDAO;
import dao.ReponseDAO;
import bo.QuestionBO;
import bo.ReponseBO;
import bo.Utilisateur;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet{

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
		if(sessionUtilisateur == null) {
			try {
				resp.sendRedirect("login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// coder ici :
			int id = Integer.parseInt(req.getParameter("id"));
			RequestDispatcher dispatcher = req.getRequestDispatcher("questionDetail.jsp");


			List<ReponseBO> pReponse = null;
			List<QuestionBO> pQuestion = null;
			try {
				pReponse = ReponseDAO.selectAllByQuestion(id);
				pQuestion = QuestionDAO.selectAllByCategorie(id);

				req.setAttribute("pReponse", pReponse);
				req.setAttribute("pQuestion", pQuestion);
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
