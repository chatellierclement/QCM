package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.deploy.uitoolkit.impl.fx.Utils;

import dao.ReponseUtilDAO;
import bo.Utilisateur;

@WebServlet ( "/validerReponse" )
public class ValiderReponseServlet extends HttpServlet {
	
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
	
	private void generate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int idReponse = Integer.parseInt(req.getParameter("demo-priority"));
		Utilisateur u = (Utilisateur) req.getSession().getAttribute("utilisateur");		
		try {
			ReponseUtilDAO.enregistrerReponse(idReponse, u.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		String id = req.getParameter("idTest"); 
		resp.sendRedirect("test?idTest=" + id);	
	}
}
