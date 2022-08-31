package metier;

import java.util.List;


import metier.entities.voyage_accompagne;


public interface panierDAO {
	public void ajouterPanier( int id_voyageAcc,int id_client);
	public int getIdVoyageAccFromDate(int id );
	public int getIdVoyageAcc(int id);
	public List<metier.entities.Panier_Voyage> getAllPanier(int idClient);
	public List<voyage_accompagne>getVoyageAcc(int id);
}
