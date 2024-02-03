package entities;

public class Client {

	private int id;
	private String nom;
	private String prenom;
	private String ville;
	private int age;
	private String email;
	private String sexe;
	private String telephone;
	private String pays;
	
	public Client() {}
	public Client(int id, String nom, String prenom, String ville, int age, String email, String sexe, String telephone, String pays) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setVille(ville);
		setAge(age);
		setEmail(email);
		setSexe(sexe);
		setTelephone(telephone);
		setPays(pays);
	}
	public Client(String nom, String ville, int age, String prenom) {
		setNom(nom);
		setPrenom(prenom);
		setVille(ville);
		setAge(age);
		setEmail(email);
		setSexe(sexe);
		setTelephone(telephone);
		setPays(pays);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
			this.prenom = prenom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;	
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSexe() {
		return this.sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getPays() {
		return this.pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", age=" + age
				+ ", email=" + email + ", sexe=" + sexe + ", telephone=" + telephone + ", pays=" + pays + "]";
	}
}
