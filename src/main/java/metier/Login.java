package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.SingletonConnection;
import metier.entities.Client;


public class Login {
	
	public boolean validation(Client CL, String password ) {
		boolean status = false ;
		Connection conn = SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from client where username =? and password=?");
			ps.setString(1, CL.getUsername());
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status =rs.next();
			System.out.println(status);
		}catch(Exception e ) {
			e.printStackTrace();
		}
				return status ;
	}

}
