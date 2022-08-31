package metier;

import java.util.List;

import metier.entities.Date_voyageAcc;

public interface DateVoyageAccDAO {
	public Date_voyageAcc getIdDateVoyageAcc(int id);
	public List<Date_voyageAcc> getAlldateVoyageAcc(int id);
	public int getIdVoyageByIdDateVoyage(int id);
	public void addDateVoyageAcc( Date_voyageAcc DV, int idVoyageAcc);
	
}
