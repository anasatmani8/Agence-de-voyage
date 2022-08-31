package metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import dao.SingletonConnection;
import metier.entities.Date_voyageAcc;


public class DateVoyageAccImp implements DateVoyageAccDAO{
	
	public Date_voyageAcc getIdDateVoyageAcc(int id) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		Date_voyageAcc v= new Date_voyageAcc();
		
		
		try {
			ps=conn.prepareStatement("select * from date_voyageacc where iddate_voyageacc=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				v.setId_date(rs.getInt("iddate_voyageacc"));
				v.setId_voyageAcc(rs.getInt("id_voyageAcc"));
				v.setDate_depart(rs.getString("date_depart"));
				v.setDate_fin(rs.getString("date_fin"));
				v.setPrix(rs.getInt("prix"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public List<Date_voyageAcc> getAlldateVoyageAcc(int id) {
		List<Date_voyageAcc>date_voyageAcc=new ArrayList<Date_voyageAcc>();
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from date_voyageacc where iddate_voyageacc=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Date_voyageAcc v=new Date_voyageAcc();
				v.setId_date(rs.getInt("iddate_voyageacc"));
				v.setId_voyageAcc(rs.getInt("id_voyageAcc"));
				v.setDate_depart(rs.getString("date_depart"));
				v.setDate_fin(rs.getString("date_fin"));
				v.setPrix(rs.getInt("prix"));
				date_voyageAcc.add(v);
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date_voyageAcc;
	}
	@Override
	public int getIdVoyageByIdDateVoyage(int id) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.voyage_accompagne V=new metier.entities.voyage_accompagne();
		try {
			ps=conn.prepareStatement("SELECT id_voyageAcc FROM date_voyageacc WHERE  iddate_voyageacc=? " );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				
				V.setId_voyageAccompagne(rs.getInt("iddate_voyageacc"));
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return V.getId_voyageAccompagne();
	}
	
	public void addDateVoyageAcc( Date_voyageAcc DV, int idVoyageAcc) {
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("INSERT into date_voyageacc (id_voyageAcc,date_depart,date_fin,prix,statut)values(?,?,?,?,'false')");
			ps.setInt(1, DV.getId_voyageAcc());
			ps.setString(2, DV.getDate_depart());
			ps.setString(3,DV.getDate_fin());
			ps.setInt(4,DV.getPrix());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
