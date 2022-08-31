package metier;

import java.util.List;

import metier.entities.DateVoyage;

public interface DatesVoyageDao {

	public List<DateVoyage> getDateById(int id);
	public int getIdVoyageByIdDateVoyage(int id);
	public void addDateVoyage( DateVoyage DV,int idVoyage);
}
