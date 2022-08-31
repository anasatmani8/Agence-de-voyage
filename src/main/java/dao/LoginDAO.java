package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import metier.entities.Admin;

public class LoginDAO {
	public static boolean validation( Admin a, String password ) {
		boolean lbool = false ;
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("select * from admin where username =? and password=?");
			ps.setString(1, a.getUsername());
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			lbool =rs.next();
			System.out.println(lbool);
		}catch(Exception e ) {
			e.printStackTrace();
		}
			return lbool ;
	}
}



