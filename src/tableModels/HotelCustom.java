package tableModels;

import java.sql.Time;

import tools.Display;

public class HotelCustom {
	private int id;
	
	private String nom_hotel;
	private String adresse_hotel;
	private String ville_hotel;
	private String description_hotel;
	private String categorie_hotel;
	private int nombre_de_chambres;
	private double superficie_moyenne_des_chambres;
	private int nombre_de_lits_simple;
	private int nombre_de_lits_double;
	/*
	private int nombre_salle_de_bains_privatives;
	private int nombre_tv;
	private int nombre_balcon;
	private int nombre_refrigerateur;
	private int nombre_baignoire;
	private int nombre_insonorisation;
	*/
	private double prix_minimum;
	private double prix_max;
	private String nom_societe;
	private String adresse_societe;
	private String siret_societe;
	private String paye_sur_total;
	private String reservations_annee_passee;
	private String reservation_annee_en_cours;
	

	

	
	public String getNom() {
		return nom_hotel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_hotel() {
		return nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}
	public String getAdresse_hotel() {
		return adresse_hotel;
	}
	public void setAdresse_hotel(String adresse_hotel) {
		this.adresse_hotel = adresse_hotel;
	}
	public String getVille_hotel() {
		return ville_hotel;
	}
	public void setVille_hotel(String ville_hotel) {
		this.ville_hotel = ville_hotel;
	}
	public String getDescription_hotel() {
		return description_hotel;
	}
	public void setDescription_hotel(String description_hotel) {
		this.description_hotel = description_hotel;
	}
	public int getNombre_de_chambres() {
		return nombre_de_chambres;
	}
	public void setNombre_de_chambres(int num) {
		this.nombre_de_chambres = num;
	}
	public String getCategorie_hotel() {
		return categorie_hotel;
	}
	public void setCategorie_hotel(String categorie_hotel) {
		this.categorie_hotel = categorie_hotel;
	}
	public double getSuperficie_moyenne_des_chambres() {
		return superficie_moyenne_des_chambres;
	}
	public void setSuperficie_moyenne_des_chambres(double superficie_moyenne_des_chambres) {
		this.superficie_moyenne_des_chambres = superficie_moyenne_des_chambres;
	}
	public void setNomHotel(String nomHotel) {
		this.nom_hotel = nomHotel;
	}
	public double getSuperficie_moyenne() {
		return superficie_moyenne_des_chambres;
	}
	public void setSuperficie_moyenne(int superficie_moyenne) {
		this.superficie_moyenne_des_chambres = superficie_moyenne;
	}
	public int getNombre_de_lits_simple() {
		return nombre_de_lits_simple;
	}
	public void setNombre_de_lits_simple(int nombre_de_lits_simple) {
		this.nombre_de_lits_simple = nombre_de_lits_simple;
	}
	public int getNombre_de_lits_double() {
		return nombre_de_lits_double;
	}
	public void setNombre_de_lits_double(int nombre_de_lits_double) {
		this.nombre_de_lits_double = nombre_de_lits_double;
	}
	public double getPrix_minimum() {
		return prix_minimum;
	}
	public void setPrix_minimum(double prix_minimum) {
		this.prix_minimum = prix_minimum;
	}
	public double getPrix_max() {
		return prix_max;
	}
	public void setPrix_max(double prix_max) {
		this.prix_max = prix_max;
	}
	public String getReservations_annee_passee() {
		return reservations_annee_passee;
	}
	public void setReservations_annee_passee(String reservations_annee_passee) {
		this.reservations_annee_passee = reservations_annee_passee;
	}
	public String getReservation_annee_en_cours() {
		return reservation_annee_en_cours;
	}
	public void setReservation_annee_en_cours(String reservation_annee_en_cours) {
		this.reservation_annee_en_cours = reservation_annee_en_cours;
	}
	/*
	 * 						hotel.getId(),
						hotel.getNom(),
						hotel.getAdresse(),
						hotel.getDescription(),
						hotel.getCategorie(),
						surfaceAvg,
						 countSimpleBed,
						 countDoubleBed,
						 minPrice,
						 maxPrice,
						 nbrReservationsPreviousYear + "",
						 nbrReservationsCurrentYear+ ""
	 */
	public HotelCustom(
			int id,
			String nomHotel,
			String adresse_hotel,
			String ville_hotel,
			String description_hotel,
			int nombre_de_chambres,
			String categorie_hotel,
			double superficie_moyenne,
			int nombre_de_lits_simple,
			int nombre_de_lits_double,
			
			double prix_minimum,
			double prix_max,
			String nom_societe,
			String adresse_societe,
			String siret_societe,
			String paiement_reservations_paye_sur_total,
			String reservations_annee_passee,
			String reservation_annee_en_cours
			) {
		this.id = id;
		this.nom_hotel = nomHotel;
		this.adresse_hotel = adresse_hotel;
		this.ville_hotel = ville_hotel;
		this.description_hotel = description_hotel;
		this.nombre_de_chambres = nombre_de_chambres;
		this.categorie_hotel = categorie_hotel;
		this.superficie_moyenne_des_chambres = superficie_moyenne;
		this.nombre_de_lits_simple = nombre_de_lits_simple;
		this.nombre_de_lits_double = nombre_de_lits_double;
		this.prix_minimum = prix_minimum;
		this.prix_max = prix_max;
		this.nom_societe = nom_societe;
		this.adresse_societe = adresse_societe;
		this.siret_societe = siret_societe;
		this.paye_sur_total = paiement_reservations_paye_sur_total;
		this.reservations_annee_passee = reservations_annee_passee;
		this.reservation_annee_en_cours = reservation_annee_en_cours;
		

	}
}
