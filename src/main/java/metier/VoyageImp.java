package metier;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import dao.SingletonConnection;
import metier.entities.TypeVoyage;


public class VoyageImp implements Voyage {

	@Override
	public List<TypeVoyage> getAllTypeVoyage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  void addVoyage(metier.entities.Voyage TV) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("INSERT INTO voyage (nom_vile,nom_hotel,description,prix_hotel,image,date_debut,date_fin) VALUES (?,?,?,?,?,?,?) ");
			ps.setString(1, TV.getNom_ville() );
			ps.setString(2, TV.getNom_hotel());
			ps.setString(3, TV.getDescription_hotel() );
			ps.setLong(4, TV.getPrix_hotel() );
			ps.setBlob(5, TV.getImage());
			ps.setString(6, TV.getDate_depart() );
			ps.setString(7, TV.getDate_fin() );
			

			
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void updateTypeVoyage(TypeVoyage TV) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTypeVoyage(TypeVoyage TV) {
		// TODO Auto-generated method stub

	}

	@Override
	public TypeVoyage getTypeVoyageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List <metier.entities.Voyage> listeVoyage(){
		List <metier.entities.Voyage> liste=new ArrayList<metier.entities.Voyage>();
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("select * from voyage ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				metier.entities.Voyage V=new metier.entities.Voyage();
				V.setDescription_hotel(rs.getString("description"));
				V.setId_voyage(rs.getInt("idvoyage"));
				V.setNom_hotel(rs.getString("nom_hotel"));
				V.setNom_ville(rs.getString("nom_vile"));
				V.setPrix_hotel(rs.getInt("prix_hotel"));
				V.setDate_depart(rs.getString("date_debut"));
				V.setDate_fin(rs.getString("date_fin"));
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
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                V.setBaseImage(base64Image);
				
			    liste.add(V);
			   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return liste;
		
	}
	public void updateVoyage(metier.entities.Voyage TV) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("update voyage set nom_hotel=?,description=?,prix_hotel=?,date_debut=?,date_fin=? where idvoyage=?");
			ps.setString(1,TV.getNom_hotel() );
			ps.setString(2, TV.getDescription_hotel());
			ps.setInt(3, TV.getPrix_hotel());
			ps.setString(4, TV.getDate_depart());
			ps.setString(5, TV.getDate_fin());
			ps.setInt(6, TV.getId_voyage());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public metier.entities.Voyage getIdVoyage(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Voyage v=new metier.entities.Voyage();
		try {
			ps=cn.prepareStatement("select * from voyage where idvoyage=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				v.setId_voyage(rs.getInt("idvoyage"));
				v.setNom_ville(rs.getString("nom_vile"));
				v.setNom_hotel(rs.getString("nom_hotel"));
				v.setDescription_hotel(rs.getString("description"));
				v.setPrix_hotel(rs.getInt("prix_hotel"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
		
	}

	@Override
	public void supprimerVoyage(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("DELETE from voyage WHERE idvoyage = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	public metier.entities.Voyage decouvrirVoyage(int id){
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Voyage v=new metier.entities.Voyage();
		try {
			ps=cn.prepareStatement("select * from voyage where idvoyage=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				v.setId_voyage(rs.getInt("idvoyage"));
				v.setNom_ville(rs.getString("nom_vile"));
				v.setNom_hotel(rs.getString("nom_hotel"));
				v.setDescription_hotel(rs.getString("description"));
				v.setPrix_hotel(rs.getInt("prix_hotel"));
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
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                v.setBaseImage(base64Image);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
		
	}
	@Override
	public String getNomVoyageById(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Voyage P=new metier.entities.Voyage();
		try {
			ps=cn.prepareStatement("SELECT nom_hotel FROM voyage WHERE  idvoyage=? " );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				P.setNom_hotel(rs.getString("nom_hotel"));
						
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return P.getNom_hotel();
	}

}
