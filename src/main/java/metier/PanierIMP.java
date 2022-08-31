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
import metier.entities.Panier_Voyage;



public class PanierIMP implements IPanier {

	@Override
	public void addPanier(int id, int idClient) {
		// TODO Auto-generated method stub
				Connection conn = SingletonConnection.getcon();
				PreparedStatement ps;
				try {
					ps=conn.prepareStatement("INSERT INTO panier (id_date_voyage,id_client) VALUES (?,?) ");
					ps.setInt(1,id );
					ps.setInt(2, idClient);
						
					ps.executeUpdate();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}

/*	@Override 
	public List<metier.entities.Voyage> listeVoyage() {
		List <metier.entities.Voyage> liste=new ArrayList<metier.entities.Voyage>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("SELECT image,date_depart, nom_hotel, prix from voyage v, dates_voyage d, panier p "
					+ "where v.idvoyage=d.id_voyage and p.id_date_voyage=d.iddates_voyage ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				metier.entities.Voyage V=new metier.entities.Voyage();
				V.setNom_hotel(rs.getString("nom_hotel"));	
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
*/
	public List<metier.entities.Panier_Voyage> getAllPanier(int idClient){
		List<metier.entities.Panier_Voyage> panier=new ArrayList<metier.entities.Panier_Voyage>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("SELECT DISTINCT image,prix,d.date_depart,d.date_fin,nom_hotel from voyage v, dates_voyage d, panier p where v.idvoyage=d.id_voyage and p.id_date_voyage=d.iddates_voyage and id_client=?");
			ps.setInt(1, idClient);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Panier_Voyage p=new Panier_Voyage();
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setDestination(rs.getString("nom_hotel"));
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
