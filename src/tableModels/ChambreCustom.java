package tableModels;

import dao.HotelDAO;
import tools.Display;

public class ChambreCustom {
	
	private String Id_chambre;
	private String Numero_de_chambre;
	private String Nombre_de_lits_simples;
	private String Nombre_de_lits_doubles;
	private String Superficie_de_la_chambre;
	
	private String Salle_de_bain_privée;
	private String Tv;
	private String Balcon; 
	private String refrigerateur;
	private String Baignoire;
	
	private String Insonorisation;
	private String Prix_de_la_chambre;
	private String Reservations_annee_courante;
	private String Reservations_annee_passee;
	private String Nom_Hotel;
	private String Adresse_hotel;
	private String categorie_Hotel;
	public ChambreCustom(String id_chambre, String numero_de_chambre, String nombre_de_lits_simples,
			String nombre_de_lits_doubles, String superficie_de_la_chambre, String salle_de_bain_privée, String tv,
			String balcon, String refrigerateur, String baignoire, String insonorisation, String prix_de_la_chambre,
			String Reservation_annee_courante, String Reservations_annee_passee, String nom_Hotel, String adresse_hotel, String categorie_Hotel) {
		Id_chambre = id_chambre;
		Numero_de_chambre = numero_de_chambre;
		Nombre_de_lits_simples = nombre_de_lits_simples;
		Nombre_de_lits_doubles = nombre_de_lits_doubles;
		Superficie_de_la_chambre = superficie_de_la_chambre;
		Salle_de_bain_privée = salle_de_bain_privée;
		Tv = tv;
		Balcon = balcon;
		this.refrigerateur = refrigerateur;
		Baignoire = baignoire;
		Insonorisation = insonorisation;
		Prix_de_la_chambre = prix_de_la_chambre;
		this.Reservations_annee_courante = Reservation_annee_courante;
		this.Reservations_annee_passee = Reservations_annee_passee;
		Nom_Hotel = nom_Hotel;
		Adresse_hotel = adresse_hotel;
		this.categorie_Hotel = categorie_Hotel;
	}


	public String getId_chambre() {
		return Id_chambre;
	}
	public void setId_chambre(String id_chambre) {
		Id_chambre = id_chambre;
	}
	public String getNumero_de_chambre() {
		return Numero_de_chambre;
	}
	public void setNumero_de_chambre(String numero_de_chambre) {
		Numero_de_chambre = numero_de_chambre;
	}
	public String getNombre_de_lits_simples() {
		return Nombre_de_lits_simples;
	}
	public void setNombre_de_lits_simples(String nombre_de_lits_simples) {
		Nombre_de_lits_simples = nombre_de_lits_simples;
	}
	public String getNombre_de_lits_doubles() {
		return Nombre_de_lits_doubles;
	}
	public void setNombre_de_lits_doubles(String nombre_de_lits_doubles) {
		Nombre_de_lits_doubles = nombre_de_lits_doubles;
	}
	public String getSuperficie_de_la_chambre() {
		return Superficie_de_la_chambre;
	}
	public void setSuperficie_de_la_chambre(String superficie_de_la_chambre) {
		Superficie_de_la_chambre = superficie_de_la_chambre;
	}
	public String getSalle_de_bain_privée() {
		return Salle_de_bain_privée;
	}
	public void setSalle_de_bain_privée(String salle_de_bain_privée) {
		Salle_de_bain_privée = salle_de_bain_privée;
	}
	public String getTv() {
		return Tv;
	}
	public void setTv(String tv) {
		Tv = tv;
	}
	public String getBalcon() {
		return Balcon;
	}
	public void setBalcon(String balcon) {
		Balcon = balcon;
	}
	public String getRefrigerateur() {
		return refrigerateur;
	}
	public void setRefrigerateur(String refrigerateur) {
		this.refrigerateur = refrigerateur;
	}
	public String getBaignoire() {
		return Baignoire;
	}
	public void setBaignoire(String baignoire) {
		Baignoire = baignoire;
	}
	public String getInsonorisation() {
		return Insonorisation;
	}
	public void setInsonorisation(String insonorisation) {
		Insonorisation = insonorisation;
	}
	public String getPrix_de_la_chambre() {
		return Prix_de_la_chambre;
	}
	public void setPrix_de_la_chambre(String prix_de_la_chambre) {
		Prix_de_la_chambre = prix_de_la_chambre;
	}
	public String getNom_Hotel() {
		return Nom_Hotel;
	}
	public void setNom_Hotel(String nom_Hotel) {
		Nom_Hotel = nom_Hotel;
	}
	public String getAdresse_hotel() {
		return Adresse_hotel;
	}
	public void setAdresse_hotel(String adresse_hotel) {
		Adresse_hotel = adresse_hotel;
	}
	public String getCategorie_Hotel() {
		return categorie_Hotel;
	}
	public void setCategorie_Hotel(String categorie_Hotel) {
		this.categorie_Hotel = categorie_Hotel;
	}
}
