package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;


public class HotelImp implements Hotel {

	@Override
	public List<metier.entities.Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHotel(metier.entities.Hotel TV) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("INSERT into hotel (nom_hotel,id_ville,nbr_etoile)values(?,?,?)");
			ps.setString(1, TV.getNom_hotel());
			ps.setInt(2, TV.getId_ville());
			ps.setInt(3,TV.getNbr_etoile());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateHotel(metier.entities.Hotel TV) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHotel(metier.entities.Hotel TV) {
		// TODO Auto-generated method stub

	}

	@Override
	public metier.entities.Hotel getHotelById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<metier.entities.Hotel> getHotelParville(int mc) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		List <metier.entities.Hotel> liste = new ArrayList<metier.entities.Hotel>();
		try {
			ps=conn.prepareStatement("SELECT * FROM hotel WHERE  id_ville=? " );
			ps.setInt(1, mc);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				metier.entities.Hotel P=new metier.entities.Hotel();
				P.setNom_hotel(rs.getString("nom_hotel"));
				
				liste.add(P);
				System.out.println(P.getNom_hotel());
			
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public int getIdByNomVille(String nom_ville) {
		
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Ville P=new metier.entities.Ville();
		try {
			ps=conn.prepareStatement("SELECT idvillle FROM ville WHERE  nom_ville=? " );
			ps.setString(1, nom_ville);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				
				P.setId_ville(rs.getInt("idvillle"));			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return P.getId_ville();
	}

}
