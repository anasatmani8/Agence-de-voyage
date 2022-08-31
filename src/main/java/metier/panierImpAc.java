package metier;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import dao.SingletonConnection;
import metier.entities.Date_voyageAcc;

import metier.entities.Panier_Voyage;
import metier.entities.voyage_accompagne;


public class panierImpAc implements panierDAO {
	
	
	public void ajouterPanier(int id_dateVoyageAcc,int id_client) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("INSERT INTO panier_acc (id_dateVoyageAcc,id_client) VALUES (?,?) ");
			ps.setInt(1, id_dateVoyageAcc);
			ps.setInt(2, id_client);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public int getIdVoyageAccFromDate(int id ) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		Date_voyageAcc p =new Date_voyageAcc() ;
		try {
			ps=conn.prepareStatement("select * from date_voyageacc where iddate_voyageacc=? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p.setId_voyageAcc(rs.getInt("id_voyageAcc"));
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setPrix(rs.getInt("prix"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.getId_voyageAcc();
		
	}
	public int getIdVoyageAcc(int id) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		voyage_accompagne v=new voyage_accompagne();
		try {
			ps=conn.prepareStatement("select * from voyage_accompagne where idvoyage_accompagné=?");
			ps.setInt(1, getIdVoyageAccFromDate(id));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				v.setId_voyageAccompagne(rs.getInt("idvoyage_Accompagné"));
				v.setDescription(rs.getString("description"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("dure"));
				v.setActivite(rs.getInt("activite"));
				v.setNom_guide(rs.getString("nom_guide"));
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setPrix(rs.getInt("prix"));
				Blob blob = (Blob) rs.getBlob("image");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            v.setBaseImage(base64Image);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v.getId_voyageAccompagne();
	}
	
	/*public List<Panier_Voyage> getAllPanier(){
		List<Panier_Voyage> panier=new ArrayList<Panier_Voyage>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("SELECT image,prix,date_depart,date_fin,destination from voyage_accompagne v, date_voyageacc d, panier p where v.idvoyage_Accompagné=d.id_voyageAcc and p.id_dateVoyageAcc=d.iddate_voyageacc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Panier_Voyage p=new Panier_Voyage();
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setDestination(rs.getString("destination"));
				p.setPrix(rs.getInt("prix"));
				Blob blob = (Blob) rs.getBlob("image");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            p.setBaseImage(base64Image);
				
				panier.add(p);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return panier;
	}*/
	
	public List<voyage_accompagne>getVoyageAcc(int id){
		List<voyage_accompagne>voyage=new ArrayList<voyage_accompagne>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from voyage_accompagne where idvoyage_Accompagné=?");
			ps.setInt(1, getIdVoyageAccFromDate(id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				voyage_accompagne v=new voyage_accompagne();
				v.setId_voyageAccompagne(rs.getInt("idvoyage_Accompagné"));
				v.setDescription(rs.getString("description"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("dure"));
				v.setActivite(rs.getInt("activite"));
				v.setNom_guide(rs.getString("nom_guide"));
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setPrix(rs.getInt("prix"));
				Blob blob = (Blob) rs.getBlob("image");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            v.setBaseImage(base64Image);
	            
	            voyage.add(v);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return voyage;
	}
	public List<metier.entities.Panier_Voyage> getAllPanier(int idClient){
		List<metier.entities.Panier_Voyage> panier=new ArrayList<metier.entities.Panier_Voyage>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("SELECT DISTINCT image,d.prix,d.date_depart,d.date_fin,destination from voyage_accompagne v, date_voyageacc d, panier_acc p where v.idvoyage_Accompagne=d.id_voyageAcc and p.id_dateVoyageAcc=d.iddate_voyageacc and id_client=?");
			ps.setInt(1, idClient);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Panier_Voyage p=new Panier_Voyage();
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setDestination(rs.getString("destination"));
				p.setPrix(rs.getInt("prix"));
				Blob blob = (Blob) rs.getBlob("image");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            p.setBaseImage(base64Image);
				
				panier.add(p);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return panier;
	}
	
	

}
