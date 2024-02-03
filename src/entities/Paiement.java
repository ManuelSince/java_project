package entities;

import java.sql.Date;

public class Paiement {
	private int id;
	private Date dateP;
	private double montant;
	private String methodeP;
	private int id_reservation;
	public Paiement() {}
	public Paiement(int id, Date dateP, double montant, String methodeP, int id_reservation) {
		setId(id);
		setDateP(dateP);
		setMontant(montant);
		setMethodeP(methodeP);
		setIdReservation(id_reservation);
	}
	public Paiement(Date dateP, double montant, String methodP, int id_reservation) {
		setDateP(dateP);
		setMontant(montant);
		setMethodeP(methodeP);
		setIdReservation(id_reservation);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateP() {
		return dateP;
	}
	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getMethodeP() {
		return methodeP;
	}
	public void setMethodeP(String methodeP) {
		this.methodeP = methodeP;
	}
	public int getIdReservation() {
		return id_reservation;
	}
	public void setIdReservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	@Override
	public String toString() {
		return "Paiement [id=" + id + ", dateP=" + dateP + ", montant=" + montant + ", methodeP=" + methodeP
				+ ", id_reservation=" + id_reservation + "]";
	}

}
