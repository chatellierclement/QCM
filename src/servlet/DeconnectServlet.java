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

import bo.CandidatBO;
import bo.TestBO;
import dao.CandidatDAO;
import dao.TestDAO;

@WebServlet("/deconnect")
public class DeconnectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		generate(request, response);
	}

	private void generate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		req.getSession().invalidate();
		req.getSession().removeAttribute("unCandidat");
		resp.sendRedirect("login");
	}

}
