package bo;

public class ReponseBO {
	
	public ReponseBO() {
		
	}
	
	private int id;
	private String libelle;
	private int etat; //0 : faux, 1 : bon 
	private QuestionBO idQuestion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public QuestionBO getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(QuestionBO idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
}
