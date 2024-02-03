package tableModels;

import dao.PaiementDAO;
import tools.Display;

public class ReservationCustom {
	private int id_reservation;
	private String nom_Client;
	private String prenom_Client;
	private String ville_Client;
	private String pays_Client;
	private String email_Client;
	private String nom_Hotel;
	private String adresse_Hotel;
	private String ville_Hotel;
	private String chambre_Reservee;
	private String salle_de_bain_privee;
	private String tv_chambre;
	private String balcon_chambre;
	private String refrigerateur_chambre;
	private String baignoire_chambre;
	private String insonorisation_chambre;
	private double prix_de_la_chambre;
	private String a_Payé;
	private int nombre_de_paiements;
	public ReservationCustom(
			int id_reservation,
			String nom_Client,
			String prenom_Client,
			String ville_Client,
			String pays_Client,
			String email_Client,
			String nom_Hotel,
			String adresse_Hotel,
			String ville_Hotel,
			String chambre_Reservee,
			String salle_de_bain_privee,
			String tv,
			String balcon,
			String refrigerateur,
			String baignoire,
			String insonorisation,
			double prix_de_la_chambre,
			String a_Payé,
			int nombre_de_paiements
			) {

		this.id_reservation = id_reservation;
		this.nom_Client = nom_Client;
		this.prenom_Client = prenom_Client;
		this.ville_Client = ville_Client;
		this.pays_Client = pays_Client;
		this.email_Client = email_Client;
		this.nom_Hotel = nom_Hotel;
		this.adresse_Hotel = adresse_Hotel;
		this.ville_Hotel = ville_Hotel;
		this.chambre_Reservee = chambre_Reservee;
		this.salle_de_bain_privee = salle_de_bain_privee;
		this.tv_chambre = tv;
		this.balcon_chambre = balcon;
		this.refrigerateur_chambre = refrigerateur;
		this.baignoire_chambre = baignoire;
		this.insonorisation_chambre = insonorisation;
		this.prix_de_la_chambre = prix_de_la_chambre;
		this.a_Payé = a_Payé;
		this.nombre_de_paiements = nombre_de_paiements;
		
	}


	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	public String getNom_Client() {
		return nom_Client;
	}
	public void setNom_Client(String nom_Client) {
		this.nom_Client = nom_Client;
	}
	public String getPrenom_Client() {
		return prenom_Client;
	}
	public void setPrenom_Client(String prenom_Client) {
		this.prenom_Client = prenom_Client;
	}
	public String getVille_Client() {
		return ville_Client;
	}
	public void setVille_Client(String ville_Client) {
		this.ville_Client = ville_Client;
	}
	public String getPays_Client() {
		return pays_Client;
	}
	public void setPays_Client(String pays_Client) {
		this.pays_Client = pays_Client;
	}
	public String getEmail_Client() {
		return email_Client;
	}
	public void setEmail_Client(String email_Client) {
		this.email_Client = email_Client;
	}
	public String getNom_Hotel() {
		return nom_Hotel;
	}
	public void setNom_Hotel(String nom_Hotel) {
		this.nom_Hotel = nom_Hotel;
	}
	public String getAdresse_Hotel() {
		return adresse_Hotel;
	}
	public void setAdresse_Hotel(String adresse_Hotel) {
		this.adresse_Hotel = adresse_Hotel;
	}
	public String getVille_Hotel() {
		return ville_Hotel;
	}
	public void setVille_Hotel(String ville_Hotel) {
		this.ville_Hotel = ville_Hotel;
	}
	public String getChambre_Reservee() {
		return chambre_Reservee;
	}
	public void setChambre_Reservee(String chambre_Reservee) {
		this.chambre_Reservee = chambre_Reservee;
	}
	public String getSalle_de_bain_privee() {
		return salle_de_bain_privee;
	}
	public void setSalle_de_bain_privee(String salle_de_bain_privee) {
		this.salle_de_bain_privee = salle_de_bain_privee;
	}
	public String getTv() {
		return tv_chambre;
	}
	public void setTv(String tv) {
		this.tv_chambre = tv;
	}
	public String getBalcon() {
		return balcon_chambre;
	}
	public void setBalcon(String balcon) {
		this.balcon_chambre = balcon;
	}
	public String getRefrigerateur() {
		return refrigerateur_chambre;
	}
	public void setRefrigerateur(String refrigerateur) {
		this.refrigerateur_chambre = refrigerateur;
	}
	public String getBaignoire() {
		return baignoire_chambre;
	}
	public void setBaignoire(String baignoire) {
		this.baignoire_chambre = baignoire;
	}
	public String getInsonorisation() {
		return insonorisation_chambre;
	}
	public void setInsonorisation(String insonorisation) {
		this.insonorisation_chambre = insonorisation;
	}
	public double getPrix_de_la_chambre() {
		return prix_de_la_chambre;
	}
	public void setPrix_de_la_chambre(double prix_de_la_chambre) {
		this.prix_de_la_chambre = prix_de_la_chambre;
	}
	public String getA_Payé() {
		return a_Payé;
	}
	public void setA_Payé(String a_Payé) {
		this.a_Payé = a_Payé;
	}
	public int getNombre_de_paiements() {
		return nombre_de_paiements;
	}
	public void setNombre_de_paiements(int nombre_de_paiements) {
		this.nombre_de_paiements = nombre_de_paiements;
	}

}
