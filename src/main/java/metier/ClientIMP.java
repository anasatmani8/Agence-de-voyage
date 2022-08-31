package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.SingletonConnection;
import metier.entities.Client;

public class ClientIMP implements ClientDAO {

	@Override
	public void addClient(Client CL) {
		Connection cn=SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("INSERT INTO Client (nom_client,prenom_client,tel_client,CNE_client,carte_bancaire,adresse,username,password) VALUES (?,?,?,?,?,?,?,md5(?)) ");
			ps.setString(1, CL.getNom_client() );
			ps.setString(2, CL.getPrenom_client());
			ps.setInt(3, CL.getTel_client());
			ps.setString(4, CL.getCNE_client());
			ps.setString(5, CL.getCarte_bancaire());
			ps.setString(6, CL.getAdresse_client());
			ps.setString(7, CL.getUsername());
			ps.setString(8, CL.getPassword());
			
	
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIdClient(String username, String password) {
		Connection cn=SingletonConnection.getConnection();
		PreparedStatement ps;
		metier.entities.Client cl = new Client();
		try {
			ps=cn.prepareStatement("SELECT idclient FROM client WHERE  username=? and password=?" );
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				cl.setIdclient(rs.getInt("idclient"));			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl.getIdclient();
	}
	
	@Override
	public String getnomClient(int id) {
		Connection cn=SingletonConnection.getConnection();
		PreparedStatement ps;
		metier.entities.Client cl = new Client();
		try {
			ps=cn.prepareStatement("SELECT nom_client FROM client WHERE idclient=?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
						
				cl.setNom_client(rs.getString("nom_client"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl.getNom_client();
	}

	@Override
	public boolean checkUserExist(String username) {
		// TODO Auto-generated method stub
		boolean lbool = false ;
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from client where username =? ");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			lbool =rs.next();
			System.out.println(lbool+" exist");
		}catch(Exception e ) {
			e.printStackTrace();
		}
			return lbool ;
	}
	
	public Client getVlientById(int id) {
		Client client = new Client();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from client where idclient =? ");
			ps.setInt(1, id); 
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				client.setIdclient(rs.getInt("idclient"));
				client.setCarte_bancaire(rs.getString("carte_bancaire"));
				client.setNom_client(rs.getString("nom_client"));
				client.setPrenom_client(rs.getString("prenom_client"));
				client.setCNE_client(rs.getString("CNE_client"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	 
 }
	
	
	}


