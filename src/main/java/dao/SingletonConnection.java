package dao;
import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.SQLException;
public class SingletonConnection {
	private static Connection connection;
	static {
		String url="jdbc:mysql://localhost:3306/agence_voyage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="D880727DATMANI";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,user,password);
			System.out.println("Connexion etablie !!!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	public static Connection getcon(){
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        String unicode="useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/agence_voyage?"+unicode, "root", "D880727DATMANI");
	    }catch(Exception ex){
	        System.out.println(ex.getMessage());
	        System.out.println("couldn't connect!");
	        throw new RuntimeException(ex);
	    }
	
	}
	
}
