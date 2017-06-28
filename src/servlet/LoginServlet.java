package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Utilisateur;
import dao.UtilisateurDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		try {
			Utilisateur utilisateur = UtilisateurDAO.selectOneByNomPrenom(nom, prenom);
			//CandidatBO unCandidat = CandidatDAO.selectOneByNomPrenom(nom, prenom);
			if(utilisateur != null) {
				HttpSession session = request.getSession();
				session.setAttribute( "utilisateur", utilisateur );
				response.sendRedirect("logged");

			} else {
				request.setAttribute("error", true);
				generate(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void generate(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
