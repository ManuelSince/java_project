package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Database;
import entities.Paiement;
import entities.Reservation;
/*
 * 	private int id;
	private Date dateP;
	private double montant;
	private String methodeP;
	private int id_reservation;
 */
public class PaiementDAO implements ICrud<Paiement> {
	public int save(Paiement obj) {
		try {
			if(obj.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Paiement SET dateP=?,montant=?,methodeP=?,id_reservation=? WHERE id=?");
				ps.setDate(1, obj.getDateP());
				ps.setDouble(2, obj.getMontant());
				ps.setString(3, obj.getMethodeP());
				ps.setInt(4, obj.getIdReservation());
				ps.setInt(5, obj.getId());
				int update_rows = ps.executeUpdate();
				if(update_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n modification du paiement réussi");
				}
				return update_rows;
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO Paiement (dateP, montant, methodeP, id_reservation) VALUES(?,?,?,?)");
				ps.setDate(1, obj.getDateP());
				ps.setDouble(2, obj.getMontant());
				ps.setString(3, obj.getMethodeP());
				ps.setInt(4, obj.getIdReservation());
				int insert_rows = ps.executeUpdate();
				if(insert_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n ajout du paiement réussi");
				}
				return insert_rows;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
			return 0;
		}
	}
	
	public Paiement getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Paiement WHERE id=? AND Deleted = 0");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			if(resultat.next()) {
				Paiement o = new Paiement();
				o.setId(resultat.getInt("id"));
				o.setDateP(resultat.getDate("dateP"));
				o.setMontant(resultat.getDouble("montant"));
				o.setMethodeP(resultat.getString("methodeP"));
				o.setIdReservation(resultat.getInt("id_reservation"));

				return o;
			} 
			// System.out.println("[ " +this.getClass().getSimpleName()+" ] => l'id "+ id +" n'existe pas ");
			return null;
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Paiement> getAll(){
		ArrayList<Paiement> list = new ArrayList<Paiement>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Paiement WHERE Deleted = 0");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Paiement o = new Paiement();
				o.setId(resultat.getInt("id"));
				o.setDateP(resultat.getDate("dateP"));
				o.setMontant(resultat.getDouble("montant"));
				o.setMethodeP(resultat.getString("methodeP"));
				o.setIdReservation(resultat.getInt("id_reservation"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<Paiement> getAllByClientId(int id_client){
		ArrayList<Paiement> list = new ArrayList<Paiement>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Paiement, Reservation WHERE Paiement.id_reservation = Reservation.id AND Reservation.id_client = ? AND Paiement.deleted = 0 AND Reservation.deleted = 0");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Paiement o = new Paiement();
				o.setId(resultat.getInt("id"));
				o.setDateP(resultat.getDate("dateP"));
				o.setMontant(resultat.getDouble("montant"));
				o.setMethodeP(resultat.getString("methodeP"));
				o.setIdReservation(resultat.getInt("id_reservation"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public ArrayList<Paiement> getAllByReservationId(int id_reservation){
		ArrayList<Paiement> list = new ArrayList<Paiement>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Paiement WHERE id_reservation = ? AND Deleted = 0");
			ps.setInt(1, id_reservation);
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Paiement o = new Paiement();
				o.setId(resultat.getInt("id"));
				o.setDateP(resultat.getDate("dateP"));
				o.setMontant(resultat.getDouble("montant"));
				o.setMethodeP(resultat.getString("methodeP"));
				o.setIdReservation(resultat.getInt("id_reservation"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
	public double getSumPaidByIdClient(int id_client) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(montant) AS paid FROM Paiement WHERE id_reservation IN(SELECT ID FROM Reservation WHERE id_client = ?)");
			ps.setInt(1, id_client);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getDouble("paid");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public double getSumPaidByReservationId(int id_reservation) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT SUM(montant) AS paid FROM Paiement WHERE id_reservation = ?");
			ps.setInt(1, id_reservation);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getDouble("paid");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int getCountPaiementsByReservationId(int id_reservation) {
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT COUNT(*) AS countPaid FROM Paiement WHERE id_reservation = ?");
			ps.setInt(1, id_reservation);
			ResultSet resultat=ps.executeQuery();
			if(resultat.next()) {
				return resultat.getInt("countPaid");
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Paiement> rechercherPaiement(String search){
		ArrayList<Paiement> list = new ArrayList<Paiement>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Paiement WHERE (dateP LIKE ? OR montant LIKE ? OR methodeP LIKE ?) AND Deleted = 0");
			ps.setString(1, "%"+ search + "%");
			ps.setString(2, "%"+ search + "%");
			ps.setString(3, "%"+ search + "%");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Paiement o = new Paiement();
				o.setId(resultat.getInt("id"));
				o.setDateP(resultat.getDate("dateP"));
				o.setMontant(resultat.getDouble("montant"));
				o.setMethodeP(resultat.getString("methodeP"));
				o.setIdReservation(resultat.getInt("id_reservation"));
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
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Paiement SET Deleted = 1 WHERE id=?");
			ps.setInt(1, id);
			int update_rows = ps.executeUpdate();
			if(update_rows == 0) {
				System.out.println(""+this.getClass().getSimpleName()+" : \n "+ id + " \n n'a pu être ajoutée ou modifiée");
			} else {
				System.out.println(""+this.getClass().getSimpleName()+" : \n le paiement : "+ id + " \n a été supprimé");
			}
			return update_rows;

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("DELETED ERROR");
			return 0;
		}
	}
	public int deleteAllByReservationId(int id_reservation) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Paiement SET Deleted = 1 WHERE id_reservation=?");
			ps.setInt(1, id_reservation);
			int update_rows = ps.executeUpdate();
			if(update_rows == 0) {
				System.out.println(""+this.getClass().getSimpleName()+" : \n aucuns paiements à supprimer pour l'id reservation: "+ id_reservation + " \n ");
			}
			return update_rows;

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("DELETED ERROR");
			return 0;
		}
	}
	public int deleteAllByClientId(int id_client) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Paiement SET Deleted = 1 WHERE id_reservation IN(SELECT * FROM Reservation WHERE id_client = ? AND deleted = 0)");
			ps.setInt(1, id_client);
			int update_rows = ps.executeUpdate();
			if(update_rows == 0) {
				System.out.println(""+this.getClass().getSimpleName()+" : \n aucuns paiements à supprimer pour l'id reservation: "+ id_client + " \n ");
			}
			return update_rows;

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("DELETED ERROR");
			return 0;
		}
	}

}
