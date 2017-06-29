package bo;

public class TestBO {
	
	private int id;
	private String libelle;
	private CategorieBO categorie;
	private int nbQuestion;
	private int duree;
	
	public TestBO() {
		
	}

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
	
	public CategorieBO getCategorie() {
		return categorie;
	}
	
	public void setCategorie(CategorieBO categorie) {
		this.categorie = categorie;
	}

	public int getNbQuestion() {
		return nbQuestion;
	}

	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
}
