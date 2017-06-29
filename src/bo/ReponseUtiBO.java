package bo;

public class ReponseUtiBO {

	private int id;
	private Utilisateur utilisateur;
	private QuestionBO question;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public QuestionBO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionBO question) {
		this.question = question;
	}
	
	
}
