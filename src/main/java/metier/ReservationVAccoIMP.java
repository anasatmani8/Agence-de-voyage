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

public class ReservationVAccoIMP implements IReservationVoyageAcc {
static int nbrR;
	@Override
	public void addReservationV(int idClient, int idVoyage, int idDateVoyage) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		PreparedStatement pr;
		
		try {
			ps=conn.prepareStatement("INSERT INTO `agence_voyage`.`reservation_voyageacc` (`idVoyageAcc`, `idClient`, `idDate_VoyageAcc`) VALUES (?,?,?);");
			ps.setInt(1,idVoyage );
			ps.setInt(3, idDateVoyage);
			ps.setInt(2, idClient);
			System.out.println(idDateVoyage);
			pr=conn.prepareStatement("UPDATE `agence_voyage`.`date_voyageacc` SET `statut` = 'true' WHERE (`iddate_voyageacc`=?)");
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
					+ "SELECT DISTINCT image,d.prix,d.date_depart,d.date_fin,destination from voyage_accompagne v, date_voyageacc d, reservation_voyageacc r where v.idvoyage_Accompagne=d.id_voyageAcc and r.idDate_VoyageAcc=d.iddate_voyageacc and r.idClient=?");
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
			String sql = "SELECT COUNT(DISTINCT idVoyageAcc,idDate_VoyageAcc,idClient) AS total\r\n"
					+ "FROM reservation_voyageacc\r\n"
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
	public void annulerReservation(int idR, int idDateV) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps, pr;
		try {
			ps=conn.prepareStatement("DELETE from reservation_voyageacc WHERE idreservation_voyageAcc = ? ");
			ps.setInt(1, idR);
		
			pr=conn.prepareStatement("UPDATE `agence_voyage`.`date_voyageacc` SET `statut` = 'false' WHERE (`iddate_voyageacc`=?)");
			pr.setInt(1, idDateV);
			ps.executeUpdate();
			pr.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public int idReservation(int idV, int idDateV, int idC) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		ReservationAcc R =new ReservationAcc();
		try {
			ps=conn.prepareStatement("SELECT idreservation_voyageAcc FROM reservation_voyageacc WHERE  idVoyageAcc=? and idClient=? and idDate_VoyageAcc=? " );
			ps.setInt(1, idV);
			ps.setInt(2, idC);
			ps.setInt(3, idDateV);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				R.setIdReservation(rs.getInt("idreservation_voyageAcc"));			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return R.getIdReservation();
	}

	@Override
	public List<ReservationAccAdmin> getAllReservationAdmin() {
		List<metier.entities.ReservationAccAdmin> panier=new ArrayList<metier.entities.ReservationAccAdmin>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("\r\n"
					+ "SELECT DISTINCT c.nom_client, image,d.prix,d.date_depart,d.date_fin,destination from client c, voyage_accompagne v, date_voyageacc d, reservation_voyageacc r where v.idvoyage_Accompagne=d.id_voyageAcc and r.idDate_VoyageAcc=d.iddate_voyageacc ");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ReservationAccAdmin p=new ReservationAccAdmin();
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setDestination(rs.getString("destination"));
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

	@Override
	public List<ReservationAccAdmin> getAllReservationAccClient(int idClient) {
		List<metier.entities.ReservationAccAdmin> panier=new ArrayList<metier.entities.ReservationAccAdmin>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("\r\n"
					+ "SELECT DISTINCT c.nom_client, image,d.prix,d.date_depart,d.date_fin,destination from client c, voyage_accompagne v, date_voyageacc d, reservation_voyageacc r where v.idvoyage_Accompagne=d.id_voyageAcc and r.idDate_VoyageAcc=d.iddate_voyageacc and c.idclient=? ");
			ps.setInt(1, idClient);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ReservationAccAdmin p=new ReservationAccAdmin();
				p.setDate_depart(rs.getString("date_depart"));
				p.setDate_fin(rs.getString("date_fin"));
				p.setDestination(rs.getString("destination"));
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
				System.out.println("je suis dans laffichage de tous les reservations pour client");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return panier;
	}

}
