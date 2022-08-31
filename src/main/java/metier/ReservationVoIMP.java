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
import metier.entities.ReservationAcc;
import metier.entities.ReservationAccAdmin;

public class ReservationVoIMP implements IReservationVoyage {
static int nbrR;
	@Override
	public void addReservationV(int idClient, int idVoyage, int idDateVoyage) {
		// TODO Auto-generated method stub
	Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		PreparedStatement pr;
		
		try {
			ps=conn.prepareStatement("INSERT INTO reservation_voyage (idVoyage,idDateVoyage,idClient) VALUES (?,?,?) ");
			ps.setInt(1,idVoyage );
			ps.setInt(2, idDateVoyage);
			ps.setInt(3, idClient);
			System.out.println(idDateVoyage);
			pr=conn.prepareStatement("UPDATE `agence_voyage`.`dates_voyage` SET `statut` = 'true' WHERE (`iddates_voyage`=?)");
			pr.setInt(1, idDateVoyage);
			ps.executeUpdate();
			pr.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		} 

	}

	@Override
	public List<metier.entities.Panier_Voyage> getAllReservation(int idClient) {
		List<metier.entities.Panier_Voyage> panier=new ArrayList<metier.entities.Panier_Voyage>();
	Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("\r\n"
					+ "SELECT DISTINCT image,prix,d.date_depart,d.date_fin,nom_hotel from voyage v, dates_voyage d, reservation_voyage r where v.idvoyage=d.id_voyage and r.idDateVoyage=d.iddates_voyage and r. idClient=?");
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
				System.out.println("je suis dans laffichage de tous les reservations");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return panier;
	}

	@Override
	public int nbrReservation(int idClient) {
	Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		ResultSet rs;
		int size = 0;
		
		try {
			String sql = "SELECT COUNT(DISTINCT idVoyage,idDateVoyage,idClient) AS total\r\n"
					+ "FROM reservation_voyage\r\n"
					+ "WHERE idClient=?;";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idClient);
			 rs=ps.executeQuery();
			 if(rs.next()){
				   size = rs.getInt(1);
				}
			
			System.out.println("nbr de reservation est  : "+size);
			nbrR=size;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbrR;
	}

	@Override
	public int idReservation(int idV, int idDateV, int idC) {
	Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		ReservationAcc R =new ReservationAcc();
		try {
			ps=conn.prepareStatement("SELECT idreservationVoyage FROM reservation_voyage WHERE  idVoyage=? and idClient=? and idDateVoyage=? " );
			ps.setInt(1, idV);
			ps.setInt(2, idC);
			ps.setInt(3, idDateV);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				R.setIdReservation(rs.getInt("idreservationVoyage"));			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return R.getIdReservation();
	}

	@Override
	public void annulerReservation(int idR, int idDate) {
	Connection conn = SingletonConnection.getcon();
		PreparedStatement ps, pr;
		try {
			ps=conn.prepareStatement("DELETE from reservation_voyage WHERE idreservationVoyage = ? ");
			ps.setInt(1, idR);
		
			pr=conn.prepareStatement("UPDATE `agence_voyage`.`dates_voyage` SET `statut` = 'false' WHERE (`iddates_voyage`=?)");
			pr.setInt(1, idDate);
			ps.executeUpdate();
			pr.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<ReservationAccAdmin> getAllReservationAdmin() {
		List<metier.entities.ReservationAccAdmin> panier=new ArrayList<metier.entities.ReservationAccAdmin>();
	Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("\r\n"
					+ "SELECT DISTINCT c.nom_client, image,prix,d.date_depart,d.date_fin,nom_hotel from voyage v, client c, dates_voyage d, reservation_voyage r where v.idvoyage=d.id_voyage and r.idDateVoyage=d.iddates_voyage  ");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ReservationAccAdmin p=new ReservationAccAdmin();
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setDestination(rs.getString("nom_hotel"));
				p.setPrix(rs.getInt("prix"));
				p.setNomC(rs.getString("nom_client"));
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
				System.out.println("je suis dans laffichage de tous les reservations pour l'admin");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return panier;
	}

}

