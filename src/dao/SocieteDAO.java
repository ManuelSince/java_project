package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Database;
import entities.Hotel;
import entities.Societe;
/*
 * 	private int id;
	private String siret;
	private String nom;
	private String adresse;
 */
public class SocieteDAO implements ICrud<Societe>{
	public int save(Societe obj) {
		try {
			if(obj.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Societe SET siret=?, nom=? adresse=? WHERE id=?");
				ps.setString(1, obj.getSiret());
				ps.setString(2, obj.getNom());
				ps.setString(3, obj.getAdresse());
				ps.setInt(4, obj.getId());
				int update_rows = ps.executeUpdate();
				if(update_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n modification de la societé réussie");
				}
				return update_rows;
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO Societe (siret,nom,adresse) VALUES(?,?,?)");
				ps.setString(1, obj.getSiret());
				ps.setString(2, obj.getNom());
				ps.setString(3, obj.getAdresse());
				int insert_rows = ps.executeUpdate();
				if(insert_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n ajout de la societé réussie");
				}
				return insert_rows;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
			return 0;
		}
	}
	
	public Societe getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Societe WHERE id=? AND Deleted = 0");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			if(resultat.next()) {
				Societe o = new Societe();
				o.setId(resultat.getInt("id"));
				o.setSiret(resultat.getString("siret"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				return o;
			} 
			// System.out.println("[ " +this.getClass().getSimpleName()+" ] => l'id "+ id +" n'existe pas ");
			return null;
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Societe> getAll(){
		ArrayList<Societe> list = new ArrayList<Societe>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Societe WHERE Deleted = 0");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Societe o = new Societe();
				o.setId(resultat.getInt("id"));
				o.setSiret(resultat.getString("siret"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
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
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE Societe SET Deleted = 1 WHERE id=?");
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
	public ArrayList<Societe> rechercherSociete(String search){
		ArrayList<Societe> list = new ArrayList<Societe>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM Hotel WHERE (siret LIKE ? OR nom LIKE ? OR adresse LIKE ?) AND Deleted = 0");
			ps.setString(1, "%"+ search + "%");
			ps.setString(2, "%"+ search + "%");
			ps.setString(3, "%"+ search + "%");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Societe o = new Societe();
				o.setId(resultat.getInt("id"));
				o.setSiret(resultat.getString("siret"));
				o.setNom(resultat.getString("nom"));
				o.setAdresse(resultat.getString("adresse"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
}
