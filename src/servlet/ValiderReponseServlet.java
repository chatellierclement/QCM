package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//String value = req.getParameter("demo-priority");
		String id = req.getParameter("idTest"); 
		resp.sendRedirect("test?idTest=" + id);
	}
}
