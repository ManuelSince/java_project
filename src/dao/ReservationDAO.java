package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Database;
import entities.Reservation;
/*
 * 	private int id;
	private Date dateA;
	private Date dateD;
	private int qte;
	private int id_client;
	private int id_chambre;
 */
public class ReservationDAO implements ICrud<Reservation> {
	public int save(Reservation obj) {
		try {
			if(obj.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Reservation SET dateA=?, dateD=?,qte=?,id_client=?, id_chambre=? WHERE id=?");
				ps.setDate(1, obj.getDateA());
				ps.setDate(2, obj.getDateD());
				ps.setInt(3, obj.getQte());
				ps.setInt(4, obj.getIdClient());
				ps.setInt(5, obj.getIdChambre());
				ps.setInt(6, obj.getId());
				int update_rows = ps.executeUpdate();
				if(update_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n modification de la réservation réussie");
				}
				return update_rows;
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO Reservation (dateA, dateD, qte, id_client, id_chambre) VALUES(?,?,?,?,?)");
				ps.setDate(1, obj.getDateA());
				ps.setDate(2, obj.getDateD());
				ps.setInt(3, obj.getQte());
				ps.setInt(4, obj.getIdClient());
				ps.setInt(5, obj.getIdChambre());
				int insert_rows = ps.executeUpdate();
				if(insert_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n ajout de la réservation réussie");
				}
				return insert_rows;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
			return 0;
		}
	}
	
	public Reservation getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Reservation WHERE id=? AND Deleted = 0");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			if(resultat.next()) {
				Reservation o = new Reservation();
				o.setId(resultat.getInt("id"));
				o.setDateA(resultat.getDate("dateA"));
				o.setDateD(resultat.getDate("dateD"));
				o.setQte(resultat.getInt("qte"));
				o.setIdClient(resultat.getInt("id_client"));
				o.setIdChambre(resultat.getInt("id_chambre"));
				return o;
			} 
			// System.out.println("[ " +this.getClass().getSimpleName()+" ] => l'id "+ id +" n'existe pas ");
			return null;
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Reservation> getAll(){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Reservation WHERE Deleted = 0");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Reservation o = new Reservation();
				o.setId(resultat.getInt("id"));
				o.setDateA(resultat.getDate("dateA"));
				o.setDateD(resultat.getDate("dateD"));
				o.setQte(resultat.getInt("qte"));
				o.setIdClient(resultat.getInt("id_client"));
				o.setIdChambre(resultat.getInt("id_chambre"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<Reservation> getAllByClientId(int id_client){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Reservation WHERE id_client = ? AND Deleted = 0");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Reservation o = new Reservation();
				o.setId(resultat.getInt("id"));
				o.setDateA(resultat.getDate("dateA"));
				o.setDateD(resultat.getDate("dateD"));
				o.setQte(resultat.getInt("qte"));
				o.setIdClient(resultat.getInt("id_client"));
				o.setIdChambre(resultat.getInt("id_chambre"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<Reservation> getAllByChambreId(int id_chambre){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Reservation WHERE id_chambre = ? AND Deleted = 0");
			ps.setInt(1, id_chambre);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Reservation o = new Reservation();
				o.setId(resultat.getInt("id"));
				o.setDateA(resultat.getDate("dateA"));
				o.setDateD(resultat.getDate("dateD"));
				o.setQte(resultat.getInt("qte"));
				o.setIdClient(resultat.getInt("id_client"));
				o.setIdChambre(resultat.getInt("id_chambre"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public double getSumReservationsPaidByIdHotel(int id_hotel) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(P.montant) AS sumPaid FROM Reservation AS R, Paiement AS P WHERE R.id = P.id_reservation AND R.id_chambre IN(SELECT id FROM Chambre WHERE id_hotel = ? AND deleted = 0) AND R.Deleted = 0 AND P.deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getDouble("sumPaid");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getSumReservationsTotalPriceByIdHotel(int id_hotel) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(C.prix) AS sumPrice FROM Reservation AS R, Chambre AS C WHERE R.id_chambre = C.id AND R.id_chambre IN(SELECT id FROM Chambre WHERE id_hotel = ? AND deleted = 0) AND R.Deleted = 0 AND C.deleted = 0");
			ps.setInt(1, id_hotel);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getDouble("sumPrice");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getReservationsCountByHotel(int id_hotel, int year) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT COUNT(*) AS reservationsCount FROM Reservation WHERE EXTRACT(YEAR FROM DateA)= ? AND id_chambre IN(SELECT id FROM Chambre WHERE id_hotel = ? AND deleted = 0) AND Deleted = 0");
			ps.setInt(1, year);
			ps.setInt(2, id_hotel);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("reservationsCount");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getReservationsCountByChambre(int id_chambre, int year) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT COUNT(*) AS reservationsCount FROM Reservation WHERE EXTRACT(YEAR FROM DateA)= ? AND id_chambre = ? AND Deleted = 0");
			ps.setInt(1, year);
			ps.setInt(2, id_chambre);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("reservationsCount");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountByIdClient(int id_client) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT COUNT(*) AS countResa FROM Reservation WHERE id_client = ? AND deleted = 0");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("countResa");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getSumPricesByClientId(int id_client) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(prix * DATEDIFF(dateD, dateA)) AS sumPrice FROM Reservation, Chambre WHERE Reservation.id_chambre = Chambre.id AND id_client = ? AND Reservation.deleted = 0 AND Chambre.deleted = 0");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getDouble("sumPrice");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getSumDaysSpentByIdClient(int id_client) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(DATEDIFF(dateD, dateA)) AS Days FROM Reservation WHERE id_client = ? AND deleted = 0");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("days");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getPreferedHotelByIdClient(int id_client) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT H.id AS hotelID, SUM(DATEDIFF(R.dateD, R.dateA)) * qte AS days FROM Reservation AS R, Chambre AS C, Hotel AS H WHERE R.id_chambre = C.id AND C.id_hotel = H.id AND R.id_client = ? AND R.deleted = 0 AND C.deleted = 0 AND H.deleted = 0 GROUP BY H.id ORDER BY days DESC");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("hotelID");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getSumPaidByIdClient(int id_client) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(montant) AS sumPrice FROM Reservation, Paiement WHERE Reservation.id = Paiement.id_reservation AND Reservation.id_client = ? AND Reservation.deleted = 0 AND Paiement.deleted = 0");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getDouble("sumPrice");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int deleteById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Reservation SET Deleted = 1 WHERE id=?");
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
	public int deleteAllByClientId(int id_client) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Reservation SET Deleted = 1 WHERE id_client=?");
			ps.setInt(1, id_client);
			int update_rows = ps.executeUpdate();
			if(update_rows == 0) {
				System.out.println(""+this.getClass().getSimpleName()+" : \n "+ id_client + " \n n'a pu être ajoutée ou modifiée");
			}
			return update_rows;

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("SAVED NO");
			return 0;
		}
	}
	public ArrayList<Reservation> rechercherReservation(String search){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Reservation WHERE (dateA LIKE ? OR dateD LIKE ? OR Qte LIKE ?) AND Deleted = 0");
			ps.setString(1, "%"+ search + "%");
			ps.setString(2, "%"+ search + "%");
			ps.setString(3, "%"+ search + "%");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Reservation o = new Reservation();
				o.setId(resultat.getInt("id"));
				o.setDateA(resultat.getDate("dateA"));
				o.setDateD(resultat.getDate("dateD"));
				o.setQte(resultat.getInt("qte"));
				o.setIdClient(resultat.getInt("id_client"));
				o.setIdChambre(resultat.getInt("id_chambre"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
}
