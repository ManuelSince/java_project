package tableModels;

public class ClientCustom {
	private String ID;
	private String Nom;
	private String Prenom;
	private String Telephone;
	private String Sexe;
	private String Ville;
	private String Pays;
	private String Email;
	private String Nombre_de_reservations;
	private String Montant_total_des_reservations;
	private String Montant_total_regle;
	private String Nombre_de_nuits;
	private String Hotel_prefere;
	private String Categorie_hotel_prefere;
	public ClientCustom(String iD, String nom, String prenom, String telephone, String sexe, String ville, String pays,
			String email, String nombre_de_reservations, String montant_total_des_reservations,
			String montant_total_regle, String nombre_de_nuits, String hotel_prefere, String categorie_hotel_prefere) {
		ID = iD;
		Nom = nom;
		Prenom = prenom;
		Telephone = telephone;
		Sexe = sexe;
		Ville = ville;
		Pays = pays;
		Email = email;
		Nombre_de_reservations = nombre_de_reservations;
		Montant_total_des_reservations = montant_total_des_reservations;
		Montant_total_regle = montant_total_regle;
		Nombre_de_nuits = nombre_de_nuits;
		Hotel_prefere = hotel_prefere;
		Categorie_hotel_prefere = categorie_hotel_prefere;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNombre_de_reservations() {
		return Nombre_de_reservations;
	}
	public void setNombre_de_reservations(String nombre_de_reservations) {
		Nombre_de_reservations = nombre_de_reservations;
	}
	public String getMontant_total_des_reservations() {
		return Montant_total_des_reservations;
	}
	public void setMontant_total_des_reservations(String montant_total_des_reservations) {
		Montant_total_des_reservations = montant_total_des_reservations;
	}
	public String getMontant_total_regle() {
		return Montant_total_regle;
	}
	public void setMontant_total_regle(String montant_total_regle) {
		Montant_total_regle = montant_total_regle;
	}
	public String getNombre_de_nuits() {
		return Nombre_de_nuits;
	}
	public void setNombre_de_nuits(String nombre_de_nuits) {
		Nombre_de_nuits = nombre_de_nuits;
	}
	public String getHotel_prefere() {
		return Hotel_prefere;
	}
	public void setHotel_prefere(String hotel_prefere) {
		Hotel_prefere = hotel_prefere;
	}
	public String getCategorie_hotel_prefere() {
		return Categorie_hotel_prefere;
	}
	public void setCategorie_hotel_prefere(String categorie_hotel_prefere) {
		Categorie_hotel_prefere = categorie_hotel_prefere;
	}
}
