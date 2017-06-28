package bo;

public class QuestionBO {
	
		
	private int id;
	private String libelle;
	private CategorieBO categorie;
	
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
	
	
}
