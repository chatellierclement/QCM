package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.TestBO;
import bo.Utilisateur;
import dao.TestDAO;
import dao.UtilisateurDAO;


@SuppressWarnings("serial")
@WebServlet ( "/listeCandidat" )
public class ListeCandidatServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		generate(request, response);
	}
	
	private void generate(HttpServletRequest request, HttpServletResponse resp) {
		Utilisateur sessionUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
		if(sessionUtilisateur == null) {
			try {
				resp.sendRedirect("login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("listeCandidat.jsp");
			
			List<Utilisateur> lesUtilisateurs = null;
			lesUtilisateurs = UtilisateurDAO.getAll();
			
			request.setAttribute("lesUtilisateurs", lesUtilisateurs);
			try {
				dispatcher.forward(request, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
