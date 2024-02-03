package tableModels;


public class PaiementCustom {
	private int id_Paiement;
	private String date_Paiement;
	private String montant_paiement;
	private String somme_total_a_regler;
	private String restant_a_payer;
	private String methode_de_paiement;
	private String numero_de_chambre;
	private String nom_hotel;
	private String ville_hotel;
	private String categorie_hotel;
	private String client_de_la_reservation;
	private String telephone;
	private String email_client;
	public PaiementCustom(int id_Paiement, String date_Paiement, String montant_paiement, String somme_total_a_regler,
			String restant_a_payer, String methode_de_paiement, String numero_de_chambre, String nom_hotel,
			String ville_hotel, String categorie_hotel, String client_de_la_reservation,String tel, String email_client) {

		this.id_Paiement = id_Paiement;
		this.date_Paiement = date_Paiement;
		this.montant_paiement = montant_paiement;
		this.somme_total_a_regler = somme_total_a_regler;
		this.restant_a_payer = restant_a_payer;
		this.methode_de_paiement = methode_de_paiement;
		this.numero_de_chambre = numero_de_chambre;
		this.nom_hotel = nom_hotel;
		this.ville_hotel = ville_hotel;
		this.categorie_hotel = categorie_hotel;
		this.client_de_la_reservation = client_de_la_reservation;
		this.telephone = tel;
		this.email_client = email_client;
	}
	public int getId_Paiement() {
		return id_Paiement;
	}
	public void setId_Paiement(int id_Paiement) {
		this.id_Paiement = id_Paiement;
	}
	public String getDate_Paiement() {
		return date_Paiement;
	}
	public void setDate_Paiement(String date_Paiement) {
		this.date_Paiement = date_Paiement;
	}
	public String getMontant_paiement() {
		return montant_paiement;
	}
	public void setMontant_paiement(String montant_paiement) {
		this.montant_paiement = montant_paiement;
	}
	public String getSomme_total_a_regler() {
		return somme_total_a_regler;
	}
	public void setSomme_total_a_regler(String somme_total_a_regler) {
		this.somme_total_a_regler = somme_total_a_regler;
	}
	public String getRestant_a_payer() {
		return restant_a_payer;
	}
	public void setRestant_a_payer(String restant_a_payer) {
		this.restant_a_payer = restant_a_payer;
	}
	public String getMethode_de_paiement() {
		return methode_de_paiement;
	}
	public void setMethode_de_paiement(String methode_de_paiement) {
		this.methode_de_paiement = methode_de_paiement;
	}
	public String getNumero_de_chambre() {
		return numero_de_chambre;
	}
	public void setNumero_de_chambre(String numero_de_chambre) {
		this.numero_de_chambre = numero_de_chambre;
	}
	public String getNom_hotel() {
		return nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}
	public String getVille_hotel() {
		return ville_hotel;
	}
	public void setVille_hotel(String ville_hotel) {
		this.ville_hotel = ville_hotel;
	}
	public String getCategorie_hotel() {
		return categorie_hotel;
	}
	public void setCategorie_hotel(String categorie_hotel) {
		this.categorie_hotel = categorie_hotel;
	}
	public String getClient_de_la_reservation() {
		return client_de_la_reservation;
	}
	public void setClient_de_la_reservation(String client_de_la_reservation) {
		this.client_de_la_reservation = client_de_la_reservation;
	}
	public String getEmail_client() {
		return email_client;
	}
	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}
}
