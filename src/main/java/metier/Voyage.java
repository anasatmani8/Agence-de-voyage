package metier;
import java.util.List;

public interface Voyage { 

	
	List <metier.entities.TypeVoyage> getAllTypeVoyage();
	void addVoyage(metier.entities.Voyage TV);
	void updateTypeVoyage(metier.entities.TypeVoyage TV);
	void deleteTypeVoyage(metier.entities.TypeVoyage TV);
	metier.entities.TypeVoyage getTypeVoyageById(int id);
	List<metier.entities.Voyage> listeVoyage();
	public metier.entities.Voyage getIdVoyage(int id);
	public void updateVoyage(metier.entities.Voyage TV);
	public void supprimerVoyage(int id);
	public metier.entities.Voyage decouvrirVoyage(int id);
	public String getNomVoyageById(int id);
	
	
}
