package metier;
import java.util.List;

public interface Ville { 

	
	List <metier.entities.Ville> getAllVille();
	void addVille(metier.entities.Ville TV);
	void updateVille(metier.entities.Ville TV);
	void deleteVille(metier.entities.Ville TV);
	metier.entities.Ville getVilleById(int id);
	
}
