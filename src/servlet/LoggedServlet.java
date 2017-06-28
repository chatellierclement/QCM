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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import bo.TestBO;
import bo.Utilisateur;
import dao.TestDAO;

@WebServlet("/logged")
public class LoggedServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(LoggedServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		generate(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		generate(req, resp);
	}
	
	private void generate(HttpServletRequest req, HttpServletResponse resp) {
		Utilisateur sessionUtilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
		
		if(sessionUtilisateur == null) {
			try {
				resp.sendRedirect("login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("logged.jsp");
			List<TestBO> listTest = null;
			try {
				listTest = TestDAO.selectAll();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.error("Erreur lors de l'appel de la fonction selectAll du fichier LoggedServlet");
			}
			
			req.setAttribute("listeTest", listTest);
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
