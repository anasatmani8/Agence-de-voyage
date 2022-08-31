package metier;

import java.util.List;

import metier.entities.Date_voyageAcc;
import metier.entities.voyage_accompagne;



public interface Voyage_accompagneDAO {

	List <metier.entities.voyage_accompagne> getAllVoyageAcc();
	void addVoyageAcc(metier.entities.voyage_accompagne TV, int id_activite);
	
	public List <metier.entities.voyage_accompagne>  get() ;
	public int getIdActiviteByNom(String nom);
	public String getNomActiviteById(int id);
	public List <metier.entities.voyage_accompagne> getVoyageByPrix(int prix);
	public List <metier.entities.voyage_accompagne> getVoyageByDestnation(String destination);
	public voyage_accompagne getIdVoyageAcc(int id);
	public void updateTypeVoyageAcc(voyage_accompagne TV);
	public void supprimerVoyageAcc(int id);
	public List<Date_voyageAcc> getDateById(int id);
	public String getNomVoyageAccById(int id);
	
	
	
}
