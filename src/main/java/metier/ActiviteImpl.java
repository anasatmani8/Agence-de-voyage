package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;
import metier.entities.Activite;

public class ActiviteImpl implements ActiviteDAO {

	@Override
	public List<Activite> getAllActivite() {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		List<metier.entities.Activite>liste=new ArrayList<metier.entities.Activite>();
		try {
			ps=cn.prepareStatement("select * from activite ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				metier.entities.Activite ville=new metier.entities.Activite();
				ville.setNom_activite(rs.getString("nom_activite"));
				liste.add( ville);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public void addActivite(String nom_activite) {
		// TODO Auto-generated method stub
				Connection cn=SingletonConnection.getcon();
				PreparedStatement ps;
				try {
					ps=cn.prepareStatement("INSERT INTO activite (nom_activite) VALUES (?) ");
					ps.setString(1, nom_activite );
					
					

					
					ps.executeUpdate();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

	}

}
