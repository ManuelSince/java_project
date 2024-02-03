package tableModels;

import tools.Display;

public class SocieteCustom {

	private String Id_societe;
	private String Siret_Societe;
	private String Prenom_Societe;
	private String Ville_Societe;
	private String Nom_hotel;
	private String Adresse_Hotel;
	private String Ville_Hotel;
	private String Categorie_hotel;
	private String Nombre_de_chambres;
	public SocieteCustom(String id_societe, String siret_Societe, String prenom_Societe, String ville_Societe,
			String nom_hotel, String adresse_Hotel, String ville_Hotel, String categorie_hotel,
			String nombre_de_chambres) {
		super();
		Id_societe = id_societe;
		Siret_Societe = siret_Societe;
		Prenom_Societe = prenom_Societe;
		Ville_Societe = ville_Societe;
		Nom_hotel = nom_hotel;
		Adresse_Hotel = adresse_Hotel;
		Ville_Hotel = ville_Hotel;
		Categorie_hotel = categorie_hotel;
		Nombre_de_chambres = nombre_de_chambres;
	}
	public String getId_societe() {
		return Id_societe;
	}
	public void setId_societe(String id_societe) {
		Id_societe = id_societe;
	}
	public String getSiret_Societe() {
		return Siret_Societe;
	}
	public void setSiret_Societe(String siret_Societe) {
		Siret_Societe = siret_Societe;
	}
	public String getPrenom_Societe() {
		return Prenom_Societe;
	}
	public void setPrenom_Societe(String prenom_Societe) {
		Prenom_Societe = prenom_Societe;
	}
	public String getVille_Societe() {
		return Ville_Societe;
	}
	public void setVille_Societe(String ville_Societe) {
		Ville_Societe = ville_Societe;
	}
	public String getNom_hotel() {
		return Nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		Nom_hotel = nom_hotel;
	}
	public String getAdresse_Hotel() {
		return Adresse_Hotel;
	}
	public void setAdresse_Hotel(String adresse_Hotel) {
		Adresse_Hotel = adresse_Hotel;
	}
	public String getVille_Hotel() {
		return Ville_Hotel;
	}
	public void setVille_Hotel(String ville_Hotel) {
		Ville_Hotel = ville_Hotel;
	}
	public String getCategorie_hotel() {
		return Categorie_hotel;
	}
	public void setCategorie_hotel(String categorie_hotel) {
		Categorie_hotel = categorie_hotel;
	}
	public String getNombre_de_chambres() {
		return Nombre_de_chambres;
	}
	public void setNombre_de_chambres(String nombre_de_chambres) {
		Nombre_de_chambres = nombre_de_chambres;
	}
}
