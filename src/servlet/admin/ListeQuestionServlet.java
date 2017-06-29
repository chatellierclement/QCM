package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CategorieBO;
import bo.QuestionBO;
import bo.Utilisateur;
import dao.CategorieDAO;
import dao.QuestionDAO;

/**
 * Servlet implementation class ListeQuestion
 */
@WebServlet("/listeQuestion")
public class ListeQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response) ;
	}

	protected void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur sessionUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
		if(sessionUtilisateur == null) {
			try {
				response.sendRedirect("login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/listeQuestion.jsp");		
			List<QuestionBO> lesQuestions = QuestionDAO.getAll();		
			request.setAttribute("listeQuestion", lesQuestions);
			
			List<CategorieBO> lesCategories = CategorieDAO.getAll();
			request.setAttribute("listeCategorie", lesCategories);
			
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
