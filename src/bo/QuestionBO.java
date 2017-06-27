package bo;

public class QuestionBO {
	
	public QuestionBO() {
		
	}
	
	private int id;
	private String libelle;
	private String description;
	private TestBO idTest;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TestBO getIdTest() {
		return idTest;
	}
	public void setIdTest(TestBO idTest) {
		this.idTest = idTest;
	}
	
	
}
