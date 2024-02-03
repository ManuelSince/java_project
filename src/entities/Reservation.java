package entities;

import java.sql.Date;

public class Reservation {
	private int id;
	private Date dateA;
	private Date dateD;
	private int qte;
	private int id_client;
	private int id_chambre;
	public Reservation() {}
	public Reservation(int id, Date dateA, Date dateD, int qte, int id_client, int id_chambre) {
		setId(id);
		setDateA(dateA);
		setDateD(dateD);
		setQte(qte);
		setIdClient(id_client);
		setIdChambre(id_chambre);
	}
	public Reservation(Date dateA, Date dateD, int qte, int id_client, int id_chambre) {
		setDateA(dateA);
		setDateD(dateD);
		setQte(qte);
		setIdClient(id_client);
		setIdChambre(id_chambre);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateA() {
		return dateA;
	}
	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getIdClient() {
		return id_client;
	}
	public void setIdClient(int id_client) {
		this.id_client = id_client;
	}
	public int getIdChambre() {
		return id_chambre;
	}
	public void setIdChambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateA=" + dateA + ", dateD=" + dateD + ", qte=" + qte + ", id_client="
				+ id_client + ", id_chambre=" + id_chambre + "]";
	}
}
