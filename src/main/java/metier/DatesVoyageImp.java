package metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;



import dao.SingletonConnection;
import metier.entities.DateVoyage;

public class DatesVoyageImp implements DatesVoyageDao {

	@Override
	public List<DateVoyage> getDateById(int id) {
		List <metier.entities.DateVoyage> liste=new ArrayList<metier.entities.DateVoyage>();
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("SELECT * FROM agence_voyage.dates_voyage where id_voyage=? and statut='false' "); // DATE(date_depart) > DATE(NOW())
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				metier.entities.DateVoyage V=new metier.entities.DateVoyage();
				System.out.println();
				V.setIddates_voyage(rs.getInt("iddates_voyage"));;
				V.setDate_depart(rs.getString("date_depart").toString());
				V.setDate_fin(rs.getString("date_fin").toString());
				V.setPrix(rs.getInt("prix"));
				V.setId_voyage(rs.getInt("id_voyage"));
				
			    liste.add(V);
			   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return liste;
		
	}

	@Override
	public int getIdVoyageByIdDateVoyage(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Voyage V=new metier.entities.Voyage();
		try {
			ps=cn.prepareStatement("SELECT id_voyage FROM dates_voyage WHERE  iddates_voyage=? " );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				
				V.setId_voyage(rs.getInt("id_voyage"));			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return V.getId_voyage();
	}

	@Override
	public void addDateVoyage( DateVoyage DV, int idVoyage) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("INSERT into dates_voyage (id_voyage,date_depart,date_fin,prix,statut)values(?,?,?,?,'false')");
			ps.setInt(1, DV.getId_voyage());
			ps.setString(2, DV.getDate_depart());
			ps.setString(3,DV.getDate_fin());
			ps.setInt(4,DV.getPrix());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
