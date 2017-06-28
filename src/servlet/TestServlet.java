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
import bo.QuestionBO;
import bo.TestBO;
import dao.CandidatDAO;
import dao.QuestionDAO;
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

		CandidatBO sessio = (CandidatBO) req.getSession().getAttribute(
				"unCandidat");

		if (sessio == null) {
			try {
				resp.sendRedirect("login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			RequestDispatcher dispatcher = req.getRequestDispatcher("test.jsp");

			int id = Integer.parseInt(req.getParameter("id"));

			List<QuestionBO> unTest = null;
			try {
				unTest = QuestionDAO.selectAllByCategorie(id);

				req.setAttribute("unTest", unTest);
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
