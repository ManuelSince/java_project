package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Chambre;
import entities.Database;
import entities.Hotel;
/*
 * 	private int id;
	private String numero;
	private int simpleBed;
	private int doubleBed;
	private int superficie;
	private int sdbP;
	private int tv;
	private int balcon;
	private int fridge;
	private int baignoire;
	private int insonorisation;
	private double prix;
	private int id_hotel;
 */

public class ChambreDAO implements ICrud<Chambre>{
	public int save(Chambre obj) {
		try {
			if(obj.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Chambre SET numero=?,simpleBed=?,doubleBed=?,superficie=?,sdbP=?,tv=?,balcon=?,fridge=?,baignoire=?,insonorisation=?,prix=?,id_hotel=? WHERE id=?");
				ps.setString(1, obj.getNumero());
				ps.setInt(2, obj.getSimpleBed());
				ps.setInt(3, obj.getDoubleBed());
				ps.setInt(4, obj.getSuperficie());
				ps.setInt(5, obj.getSdbP());
				ps.setInt(6, obj.getTv());
				ps.setInt(7, obj.getBalcon());
				ps.setInt(8, obj.getFridge());
				ps.setInt(9, obj.getBaignoire());
				ps.setInt(10, obj.getInsonorisation());
				ps.setDouble(11, obj.getPrix());
				ps.setInt(12, obj.getIdHotel());
				ps.setInt(13, obj.getId());
				int update_rows = ps.executeUpdate();
				if(update_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n modification de la chambre réussie");
				}
				return update_rows;
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO Chambre (numero,simpleBed,doubleBed,superficie,sdbP,tv,balcon,fridge,baignoire,insonorisation,prix,id_hotel) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, obj.getNumero());
				ps.setInt(2, obj.getSimpleBed());
				ps.setInt(3, obj.getDoubleBed());
				ps.setInt(4, obj.getSuperficie());
				ps.setInt(5, obj.getSdbP());
				ps.setInt(6, obj.getTv());
				ps.setInt(7, obj.getBalcon());
				ps.setInt(8, obj.getFridge());
				ps.setInt(9, obj.getBaignoire());
				ps.setInt(10, obj.getInsonorisation());
				ps.setDouble(11, obj.getPrix());
				ps.setInt(12, obj.getIdHotel());
				int insert_rows = ps.executeUpdate();
				if(insert_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \najout de la chambre réussie");
				}
				return insert_rows;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
			return 0;
		}
	}
	
	public Chambre getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Chambre WHERE id=? AND Deleted = 0");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			if(resultat.next()) {
				Chambre o = new Chambre();
				o.setId(resultat.getInt("id"));
				o.setNumero(resultat.getString("numero"));
				o.setSimpleBed(resultat.getInt("simpleBed"));
				o.setDoubleBed(resultat.getInt("doubleBed"));
				o.setSuperficie(resultat.getInt("superficie"));
				o.setSdbP(resultat.getInt("sdbP"));
				o.setTv(resultat.getInt("tv"));
				o.setBalcon(resultat.getInt("balcon"));
				o.setFridge(resultat.getInt("fridge"));
				o.setBaignoire(resultat.getInt("baignoire"));
				o.setInsonorisation(resultat.getInt("insonorisation"));
				o.setPrix(resultat.getDouble("prix"));
				o.setIdHotel(resultat.getInt("id_hotel"));
				return o;
			} 
			// System.out.println("[ " +this.getClass().getSimpleName()+" ] => l'id "+ id +" n'existe pas ");
			return null;
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Chambre> getByHotelId(int id_hotel){
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Chambre WHERE id_hotel = ? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Chambre o = new Chambre();
				o.setId(resultat.getInt("id"));
				o.setNumero(resultat.getString("numero"));
				o.setSimpleBed(resultat.getInt("simpleBed"));
				o.setDoubleBed(resultat.getInt("doubleBed"));
				o.setSuperficie(resultat.getInt("superficie"));
				o.setSdbP(resultat.getInt("sdbP"));
				o.setTv(resultat.getInt("tv"));
				o.setBalcon(resultat.getInt("balcon"));
				o.setFridge(resultat.getInt("fridge"));
				o.setBaignoire(resultat.getInt("baignoire"));
				o.setInsonorisation(resultat.getInt("insonorisation"));
				o.setPrix(resultat.getDouble("prix"));
				o.setIdHotel(resultat.getInt("id_hotel"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	
	public ArrayList<Chambre> getAll(){
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Chambre WHERE Deleted = 0 ORDER BY id_hotel, id");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Chambre o = new Chambre();
				o.setId(resultat.getInt("id"));
				o.setNumero(resultat.getString("numero"));
				o.setSimpleBed(resultat.getInt("simpleBed"));
				o.setDoubleBed(resultat.getInt("doubleBed"));
				o.setSuperficie(resultat.getInt("superficie"));
				o.setSdbP(resultat.getInt("sdbP"));
				o.setTv(resultat.getInt("tv"));
				o.setBalcon(resultat.getInt("balcon"));
				o.setFridge(resultat.getInt("fridge"));
				o.setBaignoire(resultat.getInt("baignoire"));
				o.setInsonorisation(resultat.getInt("insonorisation"));
				o.setPrix(resultat.getDouble("prix"));
				o.setIdHotel(resultat.getInt("id_hotel"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<Chambre> getAllByClientId(int id_reservation){
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Chambre, Reservation, Client WHERE Chambre.id = Reservation.id_chambre AND Reservation.id_client = Client.id AND Client.id = ? AND Chambre.deleted = 0 AND Reservation.deleted = 0 AND Client.deleted ORDER BY id_hotel, id");
			ps.setInt(1, id_reservation);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Chambre o = new Chambre();
				o.setId(resultat.getInt("id"));
				o.setNumero(resultat.getString("numero"));
				o.setSimpleBed(resultat.getInt("simpleBed"));
				o.setDoubleBed(resultat.getInt("doubleBed"));
				o.setSuperficie(resultat.getInt("superficie"));
				o.setSdbP(resultat.getInt("sdbP"));
				o.setTv(resultat.getInt("tv"));
				o.setBalcon(resultat.getInt("balcon"));
				o.setFridge(resultat.getInt("fridge"));
				o.setBaignoire(resultat.getInt("baignoire"));
				o.setInsonorisation(resultat.getInt("insonorisation"));
				o.setPrix(resultat.getDouble("prix"));
				o.setIdHotel(resultat.getInt("id_hotel"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public double getMinPriceByHotelId(int id_hotel) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT MIN(prix) AS min_price FROM Chambre WHERE id_hotel=? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getDouble("min_price");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getMinPrice() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT MIN(prix) AS min_price FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getDouble("min_price");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getMaxPriceByHotelId(int id_hotel) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT MAX(prix) AS max_price FROM Chambre WHERE id_hotel=? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getDouble("max_price");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getMaxPrice() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT MAX(prix) AS max_price FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getDouble("max_price");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getSimpleBedCountByHotelId(int id_hotel) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(simpleBed) AS simpleBed_number FROM Chambre WHERE id_hotel=? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("simpleBed_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getSimpleBedCountByCity(String city) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(simpleBed) AS simpleBed_number FROM Chambre WHERE ville=? AND Deleted = 0");
			ps.setString(1, city);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("simpleBed_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getSimpleBedCount() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(simpleBed) AS simpleBed_number FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("simpleBed_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getDoubleBedCountByHotelId(int id_hotel) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(doubleBed) AS doubleBed_number FROM Chambre WHERE id_hotel=? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("doubleBed_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getDoubleBedCountByCity(String city) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(doubleBed) AS doubleBed_number FROM Chambre WHERE ville=? AND Deleted = 0");
			ps.setString(1, city);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("doubleBed_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getDoubleBedCount() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(doubleBed) AS doubleBed_number FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("doubleBed_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getRoomCountByHotelId(int id_hotel) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT COUNT(*) AS rooms_number FROM Chambre WHERE Id_hotel=? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("rooms_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getRoomCount() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT COUNT(*) AS rooms_number FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("rooms_number");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getAverageRoomSurfaceByHotelId(int id_hotel) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT AVG(superficie) AS surface_avg FROM Chambre WHERE Id_hotel=? AND Deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("surface_avg");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getAverageRoomSurface() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT AVG(superficie) AS surface_avg FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("surface_avg");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountSdbP() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(sdbP) AS sum FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("sum");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountTv() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(tv) AS sum FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("sum");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountBalcon() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(balcon) AS sum FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("sum");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountFridge() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(fridge) AS sum FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("sum");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountBaignoire() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(baignoire) AS sum FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("sum");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountInsonorise() {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT SUM(insonorisation) AS sum FROM Chambre WHERE Deleted = 0");
			ResultSet data = ps.executeQuery();
			if(data.next()) {
				return data.getInt("sum");
			}
			return 0;

		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int deleteById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Chambre SET Deleted = 1 WHERE id=?");
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
	public ArrayList<Chambre> rechercherChambre(String search){
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Chambre, Hotel WHERE Chambre.id_hotel = Hotel.id AND (Numero LIKE ? OR Prix LIKE ? OR Ville LIKE ? OR Nom LIKE ? OR Adresse LIKE ?) AND Chambre.Deleted = 0 AND Hotel.Deleted = 0");
			ps.setString(1, "%"+ search + "%");
			ps.setString(2, "%"+ search + "%");
			ps.setString(3, "%"+ search + "%");
			ps.setString(4, "%"+ search + "%");
			ps.setString(5, "%"+ search + "%");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Chambre o = new Chambre();
				o.setId(resultat.getInt("id"));
				o.setNumero(resultat.getString("numero"));
				o.setSimpleBed(resultat.getInt("simpleBed"));
				o.setDoubleBed(resultat.getInt("doubleBed"));
				o.setSuperficie(resultat.getInt("superficie"));
				o.setSdbP(resultat.getInt("sdbP"));
				o.setTv(resultat.getInt("tv"));
				o.setBalcon(resultat.getInt("balcon"));
				o.setFridge(resultat.getInt("fridge"));
				o.setBaignoire(resultat.getInt("baignoire"));
				o.setInsonorisation(resultat.getInt("insonorisation"));
				o.setPrix(resultat.getDouble("prix"));
				o.setIdHotel(resultat.getInt("id_hotel"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n erreur recherche pour les termes " + search);
			return list;
		}
	}
}
