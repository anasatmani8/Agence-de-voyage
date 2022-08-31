package metier;

import java.util.List;

public interface IPanier {

	public void addPanier(int id, int idClient);
	//public List <metier.entities.Voyage> listeVoyage();
	public List<metier.entities.Panier_Voyage> getAllPanier(int idClient);
}
