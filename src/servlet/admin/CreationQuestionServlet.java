package servlet.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CategorieBO;
import bo.QuestionBO;
import bo.ReponseBO;
import dao.CategorieDAO;
import dao.QuestionDAO;
import dao.ReponseDAO;

/**
 * Servlet implementation class CreationQuestionServlet
 */
@WebServlet("/creationQuestion")
public class CreationQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/creationQuestion.jsp");
		
		List<CategorieBO> listeCategorie = null;
		listeCategorie = CategorieDAO.getAll();
		
		request.setAttribute("listeCategorie", listeCategorie);
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter("question");
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		String[] reponses = request.getParameterValues("reponse");
		
		if(question == null || question.length() <= 0 || reponses == null || reponses.length <= 0 || categorie <= 0) {
			doGet(request, response) ;
		}
		
		CategorieBO uneCategorie = new CategorieBO() ;
		uneCategorie.setId(categorie) ;
		
		QuestionBO uneQuestion = new QuestionBO();
		uneQuestion.setLibelle(question);
		uneQuestion.setCategorie(uneCategorie) ;	
		
		try {
			int idQuestion = QuestionDAO.enregistrer(uneQuestion);
			
			//on rajoute son id à la question
			uneQuestion.setId(idQuestion);
			
			//System.out.println(question) ;
			for(int i = 0; i < reponses.length; i++)
			{
				//System.out.println(reponses[i]);
				ReponseBO uneReponse = new ReponseBO();
				uneReponse.setLibelle(reponses[i]) ;
				uneReponse.setId(0);
				uneReponse.setQuestion(uneQuestion);
				
				try {
					ReponseDAO.enregistrer(uneReponse);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
