package metier;

import java.util.List;



public interface IReservationVoyageAcc {

	public void addReservationV(int idClient, int idVoyage, int idDateVoyage);
	public List<metier.entities.Panier_Voyage> getAllReservation(int idClient);
	public int nbrReservation(int idClient);
	public int idReservation(int idV, int idDateV, int idC);
	public void annulerReservation(int idR, int idDate);
	public List<metier.entities.ReservationAccAdmin> getAllReservationAdmin();
	public List<metier.entities.ReservationAccAdmin> getAllReservationAccClient(int idClient);
}
