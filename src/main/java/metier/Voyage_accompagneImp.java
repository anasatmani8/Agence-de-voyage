package metier;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import metier.entities.Date_voyageAcc;
import metier.entities.voyage_accompagne;

public class Voyage_accompagneImp implements Voyage_accompagneDAO {

	@Override
	public List<voyage_accompagne> getAllVoyageAcc() {
		List<voyage_accompagne>voyage=new ArrayList<voyage_accompagne>();
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("select * from voyage_accompagne");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("debut liste");
				
				voyage_accompagne v=new voyage_accompagne();
				v.setId_voyageAccompagne(rs.getInt("idvoyage_Accompagne"));
				v.setActivite(rs.getInt("activite"));
			
				
				v.setDescription(rs.getString("description"));
				v.setDestination(rs.getString("destination"));
				v.setActivite2(getNomActiviteById(rs.getInt("activite")));
			
				Blob blob = (Blob) rs.getBlob("image");
				
				v.setNom_guide(rs.getString("nom_guide"));
				v.setNom_voyage(rs.getString("nom_voyage"));
				
				
				
				InputStream inputStream = blob.getBinaryStream();
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				  byte[] buffer = new byte[4096];
	               int bytesRead = -1;
	               while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                v.setBaseImage(base64Image);

			
				voyage.add(v);
				System.out.println(voyage);
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voyage;
	}

	@Override
	public void addVoyageAcc(voyage_accompagne TV,int id_activite) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("INSERT INTO voyage_accompagne (nom_voyage,nom_guide,activite,description,destination,image) VALUES (?,?,?,?,?,?) ");
			ps.setString(1, TV.getNom_voyage() );
			ps.setString(2, TV.getNom_guide());
			ps.setInt(3, id_activite );

			ps.setString(4, TV.getDescription() );
			ps.setString(5, TV.getDestination() );
			
			ps.setBlob(6, TV.getImage());
			
			

			
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	 
	

	@Override
	public List <metier.entities.voyage_accompagne>  get()  {
		List <metier.entities.voyage_accompagne> list= new ArrayList<metier.entities.voyage_accompagne>();
		
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;

	    	
	        try  {
	        	ps=cn.prepareStatement("SELECT * FROM voyage_accompagne ");
				
	           
	            ResultSet result = ps.executeQuery();
	             
	            while (result.next()) {
	            	voyage_accompagne book = new voyage_accompagne();
	                int id = result.getInt("idvoyage_Accompagne");
	                String title = result.getString("nom_voyage");
	                System.out.println(title+"nom du voyage depuis IMP");
	             
	                Blob blob = (Blob) result.getBlob("image");
	                String destination = result.getString("destination");
	           
	                String description = result.getString("description");
	                
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                book.setId_voyageAccompagne(id);
	                book.setNom_voyage(title);
	              
	                book.setBaseImage(base64Image);
	                
	                book.setDestination(destination);
	                book.setDescription(description);
	          
	                list.add(book);
	            }          
	             
	        } catch (SQLException | IOException ex) {
	            ex.printStackTrace();
	           
	        }      
	         
	        return list;
	}

	@Override
	public int getIdActiviteByNom(String nom) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Activite P=new metier.entities.Activite();
		try {
			ps=cn.prepareStatement("SELECT idactivite FROM activite	 WHERE  nom_activite=? " );
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				
				P.setIdactivite(rs.getInt("idactivite"));			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return P.getIdactivite();
	}

	@Override
	public List<voyage_accompagne> getVoyageByPrix(int prix) {
		// TODO Auto-generated method stub
List <metier.entities.voyage_accompagne> list= new ArrayList<metier.entities.voyage_accompagne>();
		
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;

	    	
	        try  {
	        	ps=cn.prepareStatement("SELECT * FROM voyage_accompagne where prix=?");
	        	ps.setInt(1, prix);
	           
	            ResultSet result = ps.executeQuery();
	             
	            while (result.next()) {
	            	voyage_accompagne book = new voyage_accompagne();
	                
	                String title = result.getString("nom_voyage");
	                Blob blob = (Blob) result.getBlob("image");
	                String destination = result.getString("destination");
	              
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                 
	                book.setNom_voyage(title);
	                book.setPrix(prix);
	                book.setBaseImage(base64Image);
	                book.setDestination(destination);
	             
	                list.add(book);
	            }          
	             
	        } catch (SQLException | IOException ex) {
	            ex.printStackTrace();
	           
	        }      
	         
	        return list;
	}

	@Override
	public List<voyage_accompagne> getVoyageByDestnation(String destination) {
List <metier.entities.voyage_accompagne> list= new ArrayList<metier.entities.voyage_accompagne>();
		
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;

	    	
	        try  {
	        	ps=cn.prepareStatement("SELECT * FROM voyage_accompagne where destination=?");
	        	ps.setString(1, destination);
	           
	            ResultSet result = ps.executeQuery();
	             
	            while (result.next()) {
	            	voyage_accompagne book = new voyage_accompagne();
	                
	                String title = result.getString("nom_voyage");
	                Blob blob = (Blob) result.getBlob("image");
	              
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                 
	                book.setNom_voyage(title);
	           
	                book.setBaseImage(base64Image);
	                book.setDestination(destination);
	             
	                list.add(book);
	            }          
	             
	        } catch (SQLException | IOException ex) {
	            ex.printStackTrace();
	           
	        }      
	         
	        return list;
	}
	@Override
	public voyage_accompagne getIdVoyageAcc(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		voyage_accompagne v=new voyage_accompagne();
		try {
			ps=cn.prepareStatement("select * from voyage_accompagne where idvoyage_Accompagne=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				v.setId_voyageAccompagne(rs.getInt("idvoyage_Accompagne"));
				v.setDescription(rs.getString("description"));
				v.setDestination(rs.getString("destination"));
		
				v.setActivite(rs.getInt("activite"));
				v.setNom_guide(rs.getString("nom_guide"));
				v.setNom_voyage(rs.getString("nom_voyage"));
		
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
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                v.setBaseImage(base64Image);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	@Override
	public void updateTypeVoyageAcc(voyage_accompagne TV) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("update voyage_accompagne set  destination=?,description=?,activite=?,nom_guide=?,nom_voyage=? where idvoyage_Accompagne=?");
	
			ps.setString(1,TV.getDestination());
			ps.setString(2, TV.getDescription());
		
		
			ps.setInt(3, TV.getActivite());
			ps.setString(4, TV.getNom_guide());
			ps.setString(5,TV.getNom_voyage());
			ps.setInt(6, TV.getId_voyageAccompagne());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerVoyageAcc(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("DELETE from voyage_accompagne WHERE idvoyage_Accompagne = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	@Override
	public String getNomActiviteById(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.Activite P=new metier.entities.Activite();
		try {
			ps=cn.prepareStatement("SELECT nom_activite FROM activite WHERE  idactivite=? " );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				P.setNom_activite(rs.getString("nom_activite"));
						
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return P.getNom_activite();
	}
	
	public List<Date_voyageAcc> getDateById(int id) {
		List<Date_voyageAcc>liste=new ArrayList<Date_voyageAcc>();
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement("select * from date_voyageacc where id_voyageAcc=? and statut='false'");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Date_voyageAcc v= new Date_voyageAcc();
				v.setId_voyageAcc(rs.getInt("id_voyageAcc"));
				v.setId_date(rs.getInt("iddate_voyageacc"));
				v.setDate_depart(rs.getString("date_depart"));
				v.setDate_fin(rs.getString("date_fin"));
				v.setPrix(rs.getInt("prix"));
				liste.add(v);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
		
	}
	
	public String getNomVoyageAccById(int id) {
		Connection cn=SingletonConnection.getcon();
		PreparedStatement ps;
		metier.entities.voyage_accompagne P=new metier.entities.voyage_accompagne();
		try {
			ps=cn.prepareStatement("SELECT nom_voyage FROM voyage_accompagne WHERE  idvoyage_Accompagne=? " );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				P.setNom_voyage(rs.getString("nom_voyage"));
						
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return P.getNom_voyage();
	}

	
	
	
	}



