package entities;

import java.sql.Time;

public class Hotel {
	private int id;
	private String nom;
	private String adresse;
	private String ville;
	private String description;
	private int parking;
	private int wifi;
	private Time arrived_at;
	private Time leaving_at;
	private int piscine;
	private int navette;
	private int animaux;
	private int categorie;
	private int id_societe;
	public Hotel() {}
	public Hotel(
			int id, 
			String nom, 
			String adresse, 
			String ville, 
			String description, 
			int parking, 
			int wifi,
			Time arrived_at,
			Time leaving_at,
			int piscine,
			int navette,
			int animaux,
			int categorie,
			int id_societe
	) {
		setId(id);
		setNom(nom);
		setAdresse(adresse);
		setVille(ville);
		setDescription(description);
		setParking(parking);
		setWifi(wifi);
		setArrivedAt(arrived_at);
		setLeavingAt(leaving_at);
		setPiscine(piscine);
		setNavette(navette);
		setAnimaux(animaux);
		setCategorie(categorie);
		setIdSociete(id_societe);
	}
	public Hotel(
			String nom, 
			String adresse, 
			String ville, 
			String description, 
			int parking, 
			int wifi,
			Time arrived_at,
			Time leaving_at,
			int piscine,
			int navette,
			int animaux,
			int categorie,
			int id_societe
	) {
		setNom(nom);
		setAdresse(adresse);
		setVille(ville);
		setDescription(description);
		setParking(parking);
		setWifi(wifi);
		setArrivedAt(arrived_at);
		setLeavingAt(leaving_at);
		setPiscine(piscine);
		setNavette(navette);
		setAnimaux(animaux);
		setCategorie(categorie);
		setIdSociete(id_societe);
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public Time getArrivedAt() {
		return arrived_at;
	}
	public void setArrivedAt(Time arrived_at) {
		this.arrived_at = arrived_at;
	}
	public Time getLeavingAt() {
		return leaving_at;
	}
	public void setLeavingAt(Time leaving_at) {
		this.leaving_at = leaving_at;
	}
	public int getPiscine() {
		return piscine;
	}
	public void setPiscine(int piscine) {
		this.piscine = piscine;
	}
	public int getNavette() {
		return navette;
	}
	public void setNavette(int navette) {
		this.navette = navette;
	}
	public int getAnimaux() {
		return animaux;
	}
	public void setAnimaux(int animaux) {
		this.animaux = animaux;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public int getIdSociete() {
		return id_societe;
	}
	public void setIdSociete(int id_societe) {
		this.id_societe = id_societe;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", ville=" + ville + ", description="
				+ description + ", parking=" + parking + ", wifi=" + wifi + ", arrived_at=" + arrived_at
				+ ", leaving_at=" + leaving_at + ", piscine=" + piscine + ", navette=" + navette + ", animaux="
				+ animaux + ", categorie=" + categorie + ", id_societe=" + id_societe + "]";
	}
}
