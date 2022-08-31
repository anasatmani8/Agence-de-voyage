package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;

public class VilleImp implements Ville {

	@Override
	public List<metier.entities.Ville> getAllVille() {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		List<metier.entities.Ville>liste=new ArrayList<metier.entities.Ville>();
		try {
			ps=conn.prepareStatement("select * from ville ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				metier.entities.Ville ville=new metier.entities.Ville();
				ville.setNom_ville(rs.getString("nom_ville"));
				liste.add( ville);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public void addVille(metier.entities.Ville TV) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("INSERT INTO ville (nom_ville) VALUES (?) ");
			ps.setString(1, TV.getNom_ville() );
			
			

			
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void updateVille(metier.entities.Ville TV) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVille(metier.entities.Ville TV) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public metier.entities.Ville getVilleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
