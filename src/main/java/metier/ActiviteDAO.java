package metier;

import java.util.List;

public interface ActiviteDAO {

	List <metier.entities.Activite> getAllActivite();
	void addActivite(String nom_activite);
	
	
}
