package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Client;
import entities.Database;




public class ClientDAO implements ICrud<Client>{
	public int save(Client obj) {
		try {
			if(obj.getId()!=0) {
				PreparedStatement ps = Database.connexion.prepareStatement("UPDATE client SET nom=?, ville=?,age=?,prenom=?, email=?, sexe=?, telephone=?, pays=? WHERE id=?");
				ps.setString(1, obj.getNom());
				ps.setString(2, obj.getVille());
				ps.setInt(3, obj.getAge());
				ps.setString(4, obj.getPrenom());
				
				ps.setString(5, obj.getEmail());
				ps.setString(6, obj.getSexe());
				ps.setString(7, obj.getTelephone());
				ps.setString(8, obj.getPays());
				ps.setInt(5, obj.getId());
				int update_rows = ps.executeUpdate();
				if(update_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n modification du client réussi");
				}
				return update_rows;
			}else {
				PreparedStatement ps = Database.connexion.prepareStatement("INSERT INTO client (nom,ville,age, prenom, email, sexe, telephone, pays) VALUES(?,?,?,?,?,?,?,?)");
				ps.setString(1, obj.getNom());
				ps.setString(2, obj.getVille());
				ps.setInt(3, obj.getAge());
				ps.setString(4, obj.getPrenom());
				ps.setString(5, obj.getEmail());
				ps.setString(6, obj.getSexe());
				ps.setString(7, obj.getTelephone());
				ps.setString(8, obj.getPays());
				int insert_rows = ps.executeUpdate();
				if(insert_rows == 0) {
					System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
				} else {
					System.out.println(""+this.getClass().getSimpleName()+" : \n ajout du client réussi");
				}
				return insert_rows;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(""+this.getClass().getSimpleName()+" : \n "+ obj + " \n n'a pu être ajoutée ou modifiée");
			return 0;
		}
	}
	
	public Client getById(int id) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM client WHERE id=? AND Deleted = 0");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			if(resultat.next()) {
				Client o = new Client();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setPrenom(resultat.getString("prenom"));
				o.setAge(resultat.getInt("age"));
				o.setVille(resultat.getString("ville"));
				o.setEmail(resultat.getString("email"));
				o.setSexe(resultat.getString("sexe"));
				o.setTelephone(resultat.getString("telephone"));
				o.setPays(resultat.getString("pays"));
				return o;
			} 
			// System.out.println("[ " +this.getClass().getSimpleName()+" ] => l'id "+ id +" n'existe pas ");
			return null;
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Client> getAll(){
		ArrayList<Client> list = new ArrayList<Client>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM client WHERE Deleted = 0");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Client o = new Client();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setPrenom(resultat.getString("prenom"));
				o.setAge(resultat.getInt("age"));
				o.setVille(resultat.getString("ville"));
				o.setEmail(resultat.getString("email"));
				o.setSexe(resultat.getString("sexe"));
				o.setTelephone(resultat.getString("telephone"));
				o.setPays(resultat.getString("pays"));
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
			PreparedStatement ps = Database.connexion.prepareStatement("UPDATE client SET Deleted = 1 WHERE id=?");
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

	public ArrayList<Client> rechercherClient(String search){
		ArrayList<Client> list = new ArrayList<Client>();
		try {
			PreparedStatement ps=Database.connexion.prepareStatement("SELECT * FROM client WHERE (Nom LIKE ? OR Prenom LIKE ? OR Ville LIKE ? OR Email LIKE ? OR Sexe LIKE ? OR Telephone LIKE ? OR Pays LIKE ?) AND Deleted = 0");
			ps.setString(1, "%"+ search + "%");
			ps.setString(2, "%"+ search + "%");
			ps.setString(3, "%"+ search + "%");
			ps.setString(4, "%"+ search + "%");
			ps.setString(5, "%"+ search + "%");
			ps.setString(6, "%"+ search + "%");
			ps.setString(7, "%"+ search + "%");
			ResultSet resultat=ps.executeQuery();
			while(resultat.next()) {
				Client o = new Client();
				o.setId(resultat.getInt("id"));
				o.setNom(resultat.getString("nom"));
				o.setPrenom(resultat.getString("prenom"));
				o.setAge(resultat.getInt("age"));
				o.setVille(resultat.getString("ville"));
				o.setEmail(resultat.getString("email"));
				o.setSexe(resultat.getString("sexe"));
				o.setTelephone(resultat.getString("telephone"));
				o.setPays(resultat.getString("pays"));
				list.add(o);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
	}
}
