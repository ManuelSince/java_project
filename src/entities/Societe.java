package entities;

public class Societe {
	private int id;
	private String siret;
	private String nom;
	private String adresse;
	public Societe() {}
	public Societe(int id, String siret, String nom, String adresse) {
		
	}
	public Societe(String siret, String nom, String adresse) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Societe [id=" + id + ", siret=" + siret + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
}
