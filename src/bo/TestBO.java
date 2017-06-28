package bo;

public class TestBO {
	
	public TestBO() {
		
	}
	
	private int id;
	private String libelle;
	private CategorieBO idCategorie;
	
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
	public CategorieBO getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(CategorieBO idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	
}
