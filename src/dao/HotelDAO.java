package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Client;
import entities.Database;
import entities.Hotel;
/*
 * 		setId(id);
		setNom(nom);
		setAdresse(adresse);
		setVille(ville);
		setDescription(description);
		setParking(parking);
		setWifi(wifi);
		setArrived_at(arrived_at);
		setLeaving_at(leaving_at);
		setPiscine(piscine);
		setNavette(navette);
		setAnimaux(animaux);
		setCategorie(categorie);
		setId_societe(id_societe);
 */
public class HotelDAO implements ICrud<Hotel> {
	public int save(Hotel obj) {
		try {
			if(obj.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Hotel SET nom=?,adresse=?,ville=?,description=?,parking=?,wifi=?,arrived_at=?,leaving_at=?,piscine=?,navette=?,animaux=?,categorie=?,id_societe=? WHERE id=?");
				ps.setString(1, obj.getNom());
				ps.setString(2, obj.getAdresse());
				ps.setString(3, obj.getVille());
				ps.setString(4, obj.getDescription());
				ps.setInt(5, obj.getParking());
				ps.setInt(6, obj.getWifi());
				ps.setTime(7, obj.getArrivedAt());
				ps.setTime(8, obj.getLeavingAt());
				ps.setInt(9, obj.getPiscine());
				ps.setInt(10, obj.getNavette());
				ps.setInt(11, obj.getAnimaux());
				ps.setInt(12, obj.getCategorie());
				ps.setInt(13, obj.getIdSociete());
				ps.setInt(14, obj.getId());
				int update_rows = ps.executeUpdate();
				if(update_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n modification de l'hotel réussi");
				}
				return update_rows;
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO Hotel (nom,adresse,ville,description,parking,wifi,arrived_at,leaving_at,piscine,navette,animaux,categorie,id_societe) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, obj.getNom());
				ps.setString(2, obj.getAdresse());
				ps.setString(3, obj.getVille());
				ps.setString(4, obj.getDescription());
				ps.setInt(5, obj.getParking());
				ps.setInt(6, obj.getWifi());
				ps.setTime(7, obj.getArrivedAt());
				ps.setTime(8, obj.getLeavingAt());
				ps.setInt(9, obj.getPiscine());
				ps.setInt(10, obj.getNavette());
				ps.setInt(11, obj.getAnimaux());
				ps.setInt(12, obj.getCategorie());
				ps.setInt(13,  obj.getIdSociete());
				int insert_rows = ps.executeUpdate();
				if(insert_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n ajout de l'hotel réussi");
				}
				return insert_rows;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
			return 0;
		}
	}
	
	public Hotel getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Hotel WHERE id=? AND Deleted = 0");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			if(resultat.next()) {
				Hotel o = new Hotel();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				o.setVille(resultat.getString("ville"));
				o.setDescription(resultat.getString("description"));
				o.setParking(resultat.getInt("parking"));
				o.setWifi(resultat.getInt("wifi"));
				o.setArrivedAt(resultat.getTime("arrived_at"));
				o.setLeavingAt(resultat.getTime("leaving_at"));
				o.setPiscine(resultat.getInt("piscine"));
				o.setNavette(resultat.getInt("navette"));
				o.setAnimaux(resultat.getInt("animaux"));
				o.setCategorie(resultat.getInt("categorie"));
				o.setIdSociete(resultat.getInt("id_societe"));
				return o;
			} 
			// System.out.println("[ " +this.getClass().getSimpleName()+" ] => l'id "+ id +" n'existe pas ");
			return null;
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Hotel> getAll(){
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Hotel WHERE Deleted = 0");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Hotel o = new Hotel();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				o.setVille(resultat.getString("ville"));
				o.setDescription(resultat.getString("description"));
				o.setParking(resultat.getInt("parking"));
				o.setWifi(resultat.getInt("wifi"));
				o.setArrivedAt(resultat.getTime("arrived_at"));
				o.setLeavingAt(resultat.getTime("leaving_at"));
				o.setPiscine(resultat.getInt("piscine"));
				o.setNavette(resultat.getInt("navette"));
				o.setAnimaux(resultat.getInt("animaux"));
				o.setCategorie(resultat.getInt("categorie"));
				o.setIdSociete(resultat.getInt("id_societe"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<Hotel> getAllBySocieteId(int id_societe){
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Hotel WHERE id_societe = ? AND Deleted = 0");
			ps.setInt(1, id_societe);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Hotel o = new Hotel();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				o.setVille(resultat.getString("ville"));
				o.setDescription(resultat.getString("description"));
				o.setParking(resultat.getInt("parking"));
				o.setWifi(resultat.getInt("wifi"));
				o.setArrivedAt(resultat.getTime("arrived_at"));
				o.setLeavingAt(resultat.getTime("leaving_at"));
				o.setPiscine(resultat.getInt("piscine"));
				o.setNavette(resultat.getInt("navette"));
				o.setAnimaux(resultat.getInt("animaux"));
				o.setCategorie(resultat.getInt("categorie"));
				o.setIdSociete(resultat.getInt("id_societe"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<String> getCities(){
		ArrayList<String> cities = new ArrayList<String>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT DISTINCT(ville) FROM Hotel WHERE Deleted = 0");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				cities.add(resultat.getString("ville"));
			}
			return cities;
		}catch(Exception ex){
			ex.printStackTrace();
			return cities;
		}
	}
	public int getCountByCity(String city) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT COUNT(*) AS hotelsPerCountry FROM Hotel WHERE ville = ? AND Deleted = 0");
			ps.setString(1, city);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("hotelsPerCountry");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public ArrayList<Hotel> getAllByCity(String city) {
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Hotel WHERE ville = ? AND Deleted = 0");
			ps.setString(1, city);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Hotel o = new Hotel();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				o.setVille(resultat.getString("ville"));
				o.setDescription(resultat.getString("description"));
				o.setParking(resultat.getInt("parking"));
				o.setWifi(resultat.getInt("wifi"));
				o.setArrivedAt(resultat.getTime("arrived_at"));
				o.setLeavingAt(resultat.getTime("leaving_at"));
				o.setPiscine(resultat.getInt("piscine"));
				o.setNavette(resultat.getInt("navette"));
				o.setAnimaux(resultat.getInt("animaux"));
				o.setCategorie(resultat.getInt("categorie"));
				o.setIdSociete(resultat.getInt("id_societe"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public int deleteById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Hotel SET Deleted = 1 WHERE id=?");
			ps.setInt(1, id);
			int update_rows = ps.executeUpdate();
			if(update_rows == 0) {
				System.out.println(""+this.getClass().getSimpleName()+" : \n "+ id + " \n n'a pu être ajoutée ou modifiée");
			}
			return update_rows;

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("SAVED NO");
			return 0;
		}
	}
	public ArrayList<Hotel> rechercherHotel(String search){
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Hotel WHERE (Nom LIKE ? OR Adresse LIKE ? OR Ville LIKE ?) AND deleted = 0");
			ps.setString(1, "%"+ search + "%");
			ps.setString(2, "%"+ search + "%");
			ps.setString(3, "%"+ search + "%");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Hotel o = new Hotel();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				o.setVille(resultat.getString("ville"));
				o.setDescription(resultat.getString("description"));
				o.setParking(resultat.getInt("parking"));
				o.setWifi(resultat.getInt("wifi"));
				o.setArrivedAt(resultat.getTime("arrived_at"));
				o.setLeavingAt(resultat.getTime("leaving_at"));
				o.setPiscine(resultat.getInt("piscine"));
				o.setNavette(resultat.getInt("navette"));
				o.setAnimaux(resultat.getInt("animaux"));
				o.setCategorie(resultat.getInt("categorie"));
				o.setIdSociete(resultat.getInt("id_societe"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
}
